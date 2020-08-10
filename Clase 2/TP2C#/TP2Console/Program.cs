using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using TP2Console.DAO;
using TP2Console.Models;


namespace TP2Console
{
    class Program
    {

        static void Main(string[] args)
        {
            for (int code = 1; code <= 300; code++)
            {
                var json = FetchJson(code);
                if (!String.IsNullOrEmpty(json))
                {

                    foreach (var country in ParseJson(json))
                    {

                        if (FetchCountry(country.Code))
                        {

                            UpdateCountry(country);

                        }
                        else
                        {
                            InsertCountry(country);
                        }
                    }
                }
                else
                {
                    continue;
                }

            }
        }

        public static String FetchJson(int? code)
        {
            string url = "https://restcountries.eu/rest/v2/callingcode/" + code;
            string json;
            try
            {
                json = new WebClient().DownloadString(url);
            }
            catch (WebException ex)
            {
                if (ex.Status == WebExceptionStatus.ProtocolError && ex.Response != null)
                {
                    if (((HttpWebResponse)ex.Response).StatusCode == HttpStatusCode.NotFound)
                    {
                        return null;
                    }
                }
                return null;
            }

            return json;
        }


        public static List<Country> ParseJson(string json)
        {
            JArray jArray = JArray.Parse(json);
            Country country;
            List<Country> countries = new List<Country>();
            foreach (var j in jArray)
            {

                country = new Country();
                country.Code = int.Parse(j["numericCode"].ToString());
                country.Name = j["name"].ToString();
                country.Capital = j["capital"].ToString();
                country.Region = j["region"].ToString();
                country.Population = long.Parse(j["population"].ToString());
                country.Latitude = double.Parse((j["latlng"][0]).ToString());
                country.Longitude = double.Parse((j["latlng"][1]).ToString());
                countries.Add(country);
            }


            return countries;
        }



        public static bool FetchCountry(int? code)
        {
            CountryDAODataContext dataContext = new CountryDAODataContext();

            try
            {
                return dataContext.pais.Any(x => x.codigo == code);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }

        public static void UpdateCountry(Country country)
        {
            CountryDAODataContext dataContext = new CountryDAODataContext();
            pais p = dataContext.pais.Single(pais => pais.codigo == country.Code);

            p.nombre = country.Name;
            p.capital = country.Capital;
            p.region = country.Region;
            p.poblacion = country.Population;
            p.latitud = double.Parse(country.Latitude.ToString());
            p.longitud = double.Parse(country.Longitude.ToString());

            try
            {
                dataContext.SubmitChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

        }

        public static void InsertCountry(Country country)
        {
            CountryDAODataContext dataContext = new CountryDAODataContext();

            pais pais = new pais
            {
                codigo = (int)country.Code,
                nombre = country.Name,
                capital = country.Capital,
                region = country.Region,
                poblacion = country.Population,
                latitud = double.Parse(country.Latitude.ToString()),
                longitud = double.Parse(country.Latitude.ToString())
            };


            dataContext.pais.InsertOnSubmit(pais);

            try
            {
                dataContext.SubmitChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);

            }

        }
    }
}
