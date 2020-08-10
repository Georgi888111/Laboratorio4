namespace TP2Console.Models
{
    class Country
    {
        private int? code;
        private string name;
        private string capital;
        private string region;
        private long population;
        private double latitude;
        private double longitude;

        public Country()
        {
        }

        public Country(int? code, string name, string capital, string region, long population, double latitude, double longitude)
        {
            this.Code = code;
            this.Name = name;
            this.Capital = capital;
            this.Region = region;
            this.Population = population;
            this.Latitude = latitude;
            this.Longitude = longitude;
        }

        public int? Code { get => code; set => code = value; }
        public string Name { get => name; set => name = value; }
        public string Capital { get => capital; set => capital = value; }
        public string Region { get => region; set => region = value; }
        public long Population { get => population; set => population = value; }
        public double Latitude { get => latitude; set => latitude = value; }
        public double Longitude { get => longitude; set => longitude = value; }
    }
}
