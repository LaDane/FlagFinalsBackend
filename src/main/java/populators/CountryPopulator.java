package populators;

import entities.Continent;
import entities.Country;
import errorhandling.NotFoundException;
import facades.ContinentFacade;
import facades.CountryFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryPopulator {

    public static void main(String[] args) throws NotFoundException, IOException {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        populateCountries(emf);
    }

    public static void populateCountries(EntityManagerFactory emf) throws NotFoundException, IOException {
        populateCountriesEurope(emf);
        populateCountriesAsia(emf);
        populateCountriesOceania(emf);
        populateCountriesSouthAmerica(emf);
        populateCountriesAfrica(emf);
        populateCountriesNorthAmerica(emf);
    }


    public static void populateCountriesEurope(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent europe = ContinentFacade.getFacade(emf).getByName("Europe");

        Country germany = new Country("Germany", europe, "276");
        //Country gb = new Country("Great Britain", europe, "826");
        Country england = new Country("England", europe, "gb-eng");
        Country wales = new Country("Wales", europe, "gb-wls");
        Country scotland = new Country("Scotland", europe, "gb-sct");
        Country northIreland = new Country("North Ireland", europe, "gb-nir");

        Country france = new Country("France", europe, "250");
        Country italy = new Country("Italy", europe, "380");
        Country spain = new Country("Spain", europe, "724");
        Country ukraine = new Country("Ukraine", europe, "804");
        Country russia = new Country("Russia", europe, "643");
        Country poland = new Country("Poland", europe, "616");
        Country romania = new Country("Romania", europe, "642");
        Country netherlands = new Country("Netherlands", europe, "528");
        Country belgium = new Country("Belgium", europe, "056");
        Country greece = new Country("Greece", europe, "300");
        Country portugal = new Country("Portugal", europe, "620");
        Country sweden = new Country("Sweden", europe, "752");
        Country hungary = new Country("Hungary", europe, "348");
        Country belarus = new Country("Belarus", europe, "112");
        Country austria = new Country("Austria", europe, "040");
        Country serbia = new Country("Serbia", europe, "688");
        Country switzerland = new Country("Switzerland", europe, "756");
        Country denmark = new Country("Denmark", europe, "208");
        Country norway = new Country("Norway", europe, "578");
        Country bulgaria = new Country("Bulgaria", europe, "100");
        Country finland = new Country("Finland", europe, "246");
        Country slovakia = new Country("Slovakia", europe, "703");
        Country ireland = new Country("Ireland", europe, "372");
        Country croatia = new Country("Croatia", europe, "191");
        Country moldova = new Country("Moldova", europe, "498");
        Country bosnia = new Country("Bosnia & Herz.", europe, "070");
        Country albania = new Country("Albania", europe, "008");
        Country lithuania = new Country("Lithuania", europe, "440");
        Country northMacedonia = new Country("North Macedonia", europe, "807");
        Country slovenia = new Country("Slovenia", europe, "705");
        Country latvia = new Country("Latvia", europe, "428");
        Country estonia = new Country("Estonia", europe, "233");
        Country montenegro = new Country("Montenegro", europe, "499");
        Country luxembourg = new Country("Luxembourg", europe, "442");
        Country malta = new Country("Malta", europe, "470");
        Country iceland = new Country("Iceland", europe, "352");
        Country andorra = new Country("Andorra", europe, "020");
        Country monaco = new Country("Monaco", europe, "492");
        Country liechtenstein = new Country("Liechtenstein", europe, "438");
        Country sanMarino = new Country("San Marino", europe, "674");




        try {
            em.getTransaction().begin();
            em.persist(germany);
            //em.persist(gb);
            em.persist(england);
            em.persist(wales);
            em.persist(scotland);
            em.persist(northIreland);
            em.persist(france);
            em.persist(italy);
            em.persist(spain);
            em.persist(ukraine);
            em.persist(russia);
            em.persist(poland);
            em.persist(romania);
            em.persist(netherlands);
            em.persist(belgium);
            em.persist(greece);
            em.persist(portugal);
            em.persist(sweden);
            em.persist(hungary);
            em.persist(belarus);
            em.persist(austria);
            em.persist(serbia);
            em.persist(switzerland);
            em.persist(denmark);
            em.persist(norway);
            em.persist(bulgaria);
            em.persist(finland);
            em.persist(slovakia);
            em.persist(finland);
            em.persist(ireland);
            em.persist(croatia);
            em.persist(moldova);
            em.persist(bosnia);
            em.persist(albania);
            em.persist(lithuania);
            em.persist(northMacedonia);
            em.persist(slovenia);
            em.persist(latvia);
            em.persist(estonia);
            em.persist(montenegro);
            em.persist(luxembourg);
            em.persist(malta);
            em.persist(iceland);
            em.persist(andorra);
            em.persist(monaco);
            em.persist(liechtenstein);
            em.persist(sanMarino);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void populateCountriesAsia(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent asia = ContinentFacade.getFacade(emf).getByName("Asia");

        Country china = new Country("China", asia, "156");
        Country india = new Country("India", asia, "356");
        Country indonesia = new Country("Indonesia", asia, "360");
        Country pakistan = new Country("Pakistan", asia, "586");
        Country bangladesh = new Country("Bangladesh", asia, "050");
        Country japan = new Country("Japan", asia, "392");
        Country philippines = new Country("Philippines", asia, "608");
        Country vietnam = new Country("Vietnam", asia, "704");
        Country turkey = new Country("Turkey", asia, "792");
        Country iran = new Country("Iran", asia, "364");
        Country thailand = new Country("Thailand", asia, "764");
        Country myanmar = new Country("Myanmar", asia, "104");
        Country southKorea = new Country("South Korea", asia, "410");
        Country iraq = new Country("Iraq", asia, "368");
        Country afghanistan = new Country("Afghanistan", asia, "004");
        Country saudiArabia = new Country("Saudi Arabia", asia, "682");
        Country uzbekistan = new Country("Uzbekistan", asia, "860");
        Country malaysia = new Country("Malaysia", asia, "458");
        Country yemen = new Country("Yemen", asia, "887");
        Country nepal = new Country("Nepal", asia, "524");
        Country northKorea = new Country("North Korea", asia, "408");
        Country sriLanka = new Country("Sri Lanka", asia, "144");
        Country kazakhstan = new Country("Kazakhstan", asia, "398");
        Country syria = new Country("Syria", asia, "760");
        Country cambodia = new Country("Cambodia", asia, "116");
        Country jordan = new Country("Jordan", asia, "400");
        Country azerbaijan = new Country("Azerbaijan", asia, "031");
        Country uae = new Country("United Arab Emirates", asia, "784");
        Country tajikistan = new Country("Tajikistan", asia, "762");
        Country israel = new Country("Israel", asia, "376");
        Country laos = new Country("Laos", asia, "418");
        Country lebanon = new Country("Lebanon", asia, "422");
        Country kyrgyzstan = new Country("Kyrgyzstan", asia, "417");
        Country turkmenistan = new Country("Turkmenistan", asia, "795");
        Country singapore = new Country("Singapore", asia, "702");
        Country oman = new Country("Oman", asia, "512");
        Country palestine = new Country("Palestine", asia, "275");
        Country kuwait = new Country("Kuwait", asia, "414");
        Country georgia = new Country("Georgia", asia, "268");
        Country mongolia = new Country("Mongolia", asia, "496");
        Country armenia = new Country("Armenia", asia, "051");
        Country qatar = new Country("Qatar", asia, "634");
        Country bahrain = new Country("Bahrain", asia, "048");
        Country timor = new Country("Timor-Leste", asia, "626");
        Country cyprus = new Country("Cyprus", asia, "196");
        Country bhutan = new Country("Bhutan", asia, "064");
        Country maldives = new Country("Maldives", asia, "462");
        Country brunei = new Country("Brunei", asia, "096");
        Country taiwan = new Country("Taiwan", asia, "158");
        Country hongKong = new Country("Hong Kong", asia, "344");
        Country macao = new Country("Macao", asia, "446");




        try {
            em.getTransaction().begin();

            em.persist(china);
            em.persist(india);
            em.persist(indonesia);
            em.persist(pakistan);
            em.persist(bangladesh);
            em.persist(japan);
            em.persist(philippines);
            em.persist(vietnam);
            em.persist(turkey);
            em.persist(iran);
            em.persist(thailand);
            em.persist(myanmar);
            em.persist(southKorea);
            em.persist(iraq);
            em.persist(afghanistan);
            em.persist(saudiArabia);
            em.persist(uzbekistan);
            em.persist(malaysia);
            em.persist(yemen);
            em.persist(nepal);
            em.persist(northKorea);
            em.persist(sriLanka);
            em.persist(kazakhstan);
            em.persist(kazakhstan);
            em.persist(syria);
            em.persist(cambodia);
            em.persist(jordan);
            em.persist(azerbaijan);
            em.persist(uae);
            em.persist(tajikistan);
            em.persist(israel);
            em.persist(laos);
            em.persist(lebanon);
            em.persist(kyrgyzstan);
            em.persist(turkmenistan);
            em.persist(singapore);
            em.persist(oman);
            em.persist(palestine);
            em.persist(kuwait);
            em.persist(georgia);
            em.persist(mongolia);
            em.persist(armenia);
            em.persist(qatar);
            em.persist(bahrain);
            em.persist(timor);
            em.persist(cyprus);
            em.persist(bhutan);
            em.persist(maldives);
            em.persist(brunei);
            em.persist(taiwan);
            em.persist(hongKong);
            em.persist(macao);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void populateCountriesSouthAmerica(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent southAmerica = ContinentFacade.getFacade(emf).getByName("South America and Oceania");

        Country brazil = new Country("Brazil", southAmerica, "076");
        Country colombia = new Country("Colombia", southAmerica, "170");
        Country argentina = new Country("Argentina", southAmerica, "032");
        Country peru = new Country("Peru", southAmerica, "604");
        Country venezuela = new Country("Venezuela", southAmerica, "862");
        Country chile = new Country("Chile", southAmerica, "152");
        Country ecuador = new Country("Ecuador", southAmerica, "218");
        Country bolivia = new Country("Bolivia", southAmerica, "068");
        Country paraguay = new Country("Paraguay", southAmerica, "600");
        Country uruguay = new Country("Uruguay", southAmerica, "858");
        Country guyana = new Country("Guyana", southAmerica, "328");
        Country surinam = new Country("Surinam", southAmerica, "740");
        Country frenchGuiana = new Country("French Guiana", southAmerica, "254");
        Country falklandIslands = new Country("Falkland Islands", southAmerica, "238");


        try {
            em.getTransaction().begin();

            em.persist(brazil);
            em.persist(colombia);
            em.persist(argentina);
            em.persist(peru);
            em.persist(venezuela);
            em.persist(chile);
            em.persist(ecuador);
            em.persist(bolivia);
            em.persist(paraguay);
            em.persist(uruguay);
            em.persist(guyana);
            em.persist(surinam);
            em.persist(frenchGuiana);
            em.persist(falklandIslands);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void populateCountriesOceania(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent oceania = ContinentFacade.getFacade(emf).getByName("South America and Oceania");

        Country australia = new Country("Australia", oceania, "036");
        Country papuaNewGuinea = new Country("Papua New Guinea", oceania, "598");
        Country newZealand = new Country("New Zealand", oceania, "554");
        Country fiji = new Country("Fiji", oceania, "242");
        Country solomonIslands = new Country("Solomon Islands", oceania, "090");
        Country micronesia = new Country("Micronesia", oceania, "583");
        Country vanuatu = new Country("Vanuatu", oceania, "548");
        Country samoa = new Country("Samoa", oceania, "882");
        Country kiribati = new Country("Kiribati", oceania, "296");
        Country tonga = new Country("Tonga", oceania, "776");
        Country marshallIslands = new Country("Marshall Islands", oceania, "584");
        Country palau = new Country("Palau", oceania, "585");
        Country tuvalu = new Country("Tuvalu", oceania, "798");
        Country nauru = new Country("Nauru", oceania, "520");


        try {
            em.getTransaction().begin();

            em.persist(australia);
            em.persist(papuaNewGuinea);
            em.persist(newZealand);
            em.persist(fiji);
            em.persist(solomonIslands);
            em.persist(micronesia);
            em.persist(vanuatu);
            em.persist(samoa);
            em.persist(kiribati);
            em.persist(tonga);
            em.persist(marshallIslands);
            em.persist(palau);
            em.persist(tuvalu);
            em.persist(nauru);



            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public static void populateCountriesAfrica(EntityManagerFactory emf) throws NotFoundException, IOException {
        EntityManager em = emf.createEntityManager();
        Continent africa = ContinentFacade.getFacade(emf).getByName("Africa");

        Country algeria = new Country("Algeria", africa, "012");
        Country angola = new Country("Angola", africa, "024");
        Country benin = new Country("Benin", africa, "204");
        Country botswana = new Country("Botswana", africa, "072");
        Country burkinaFaso = new Country("Burkina Faso", africa, "854");
        Country burundi = new Country("Burundi", africa, "108");
        Country caboVerde = new Country("Cabo Verde", africa, "132");
        Country cameroon = new Country("Cameroon", africa, "120");
        Country CAR = new Country("Central African Republic", africa, "140");
        Country chad = new Country("Chad", africa, "148");
        Country comoros = new Country("Comoros", africa, "174");
        Country congo = new Country("Congo", africa, "178");
        Country DRC = new Country("Democratic Republic of Congo", africa, "180");
        Country cotedIvoire = new Country("Cote d'Ivoire", africa, "384");
        Country djibouti = new Country("Djibouti", africa, "262");
        Country egypt = new Country("Egypt", africa, "818");
        Country equatorialGuinea = new Country("Equatorial Guinea", africa, "262");
        Country eritrea = new Country("Eritrea", africa, "232");
        Country eswatini = new Country("Eswatini", africa, "748");
        Country ethiopia = new Country("Ethiopia", africa, "231");
        Country gabon = new Country("Gabon", africa, "266");
        Country gambia = new Country("Gambia", africa, "270");
        Country ghana = new Country("Ghana", africa, "288");
        Country guinea = new Country("Guinea", africa, "324");
        Country guineaBissau = new Country("Guinea-Bissau", africa, "624");
        Country kenya = new Country("Kenya", africa, "404");
        Country lesotho = new Country("Lesotho", africa, "426");
        Country liberia = new Country("Liberia", africa, "430");
        Country libya = new Country("Libya", africa, "434");
        Country madagascar = new Country("Madagascar", africa, "450");
        Country malawi = new Country("Malawi", africa, "454");
        Country mali = new Country("Mali", africa, "466");
        Country mauritania = new Country("Mauritania", africa, "478");
        Country mauritius = new Country("Mauritius", africa, "480");
        Country morocco = new Country("Morocco", africa, "504");
        Country mozambique = new Country("Mozambique", africa, "508");
        Country namibia = new Country("Namibia", africa, "516");
        Country niger = new Country("Niger", africa, "562");
        Country nigeria = new Country("Nigeria", africa, "566");
        Country rwanda = new Country("Rwanda", africa, "646");
        Country saoTomeAndPrinipe = new Country("Sao Tome and Principe", africa, "678");
        Country senegal = new Country("Senegal", africa, "686");
        Country seychelles = new Country("Seychelles", africa, "690");
        Country sierraLeone = new Country("Sierra Leone", africa, "694");
        Country somalia = new Country("Somalia", africa, "706");
        Country southAfrica = new Country("South Africa", africa, "710");
        Country southSudan = new Country("South Sudan", africa, "728");
        Country sudan = new Country("Sudan", africa, "729");
        Country tanzania = new Country("Tanzania", africa, "834");
        Country togo = new Country("Togo", africa, "768");
        Country tunisia = new Country("Tunisia", africa, "788");
        Country uganda = new Country("Uganda", africa, "800");
        Country zambia = new Country("Zambia", africa, "894");
        Country zimbabwe = new Country("Zimbabwe", africa, "716");

        try {

            em.getTransaction().begin();

            em.persist(algeria);
            em.persist(angola);
            em.persist(benin);
            em.persist(botswana);
            em.persist(burkinaFaso);
            em.persist(burundi);
            em.persist(caboVerde);
            em.persist(cameroon);
            em.persist(CAR);
            em.persist(chad);
            em.persist(comoros);
            em.persist(congo);
            em.persist(DRC);
            em.persist(cotedIvoire);
            em.persist(djibouti);
            em.persist(egypt);
            em.persist(equatorialGuinea);
            em.persist(eswatini);
            em.persist(eritrea);
            em.persist(ethiopia);
            em.persist(gabon);
            em.persist(gambia);
            em.persist(ghana);
            em.persist(guinea);
            em.persist(guineaBissau);
            em.persist(kenya);
            em.persist(lesotho);
            em.persist(liberia);
            em.persist(libya);
            em.persist(madagascar);
            em.persist(malawi);
            em.persist(mali);
            em.persist(mauritania);
            em.persist(mauritius);
            em.persist(morocco);
            em.persist(mozambique);
            em.persist(namibia);
            em.persist(niger);
            em.persist(nigeria);
            em.persist(rwanda);
            em.persist(saoTomeAndPrinipe);
            em.persist(senegal);
            em.persist(seychelles);
            em.persist(sierraLeone);
            em.persist(somalia);
            em.persist(southAfrica);
            em.persist(southSudan);
            em.persist(sudan);
            em.persist(tanzania);
            em.persist(togo);
            em.persist(tunisia);
            em.persist(uganda);
            em.persist(zambia);
            em.persist(zimbabwe);

            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }


        public static void populateCountriesNorthAmerica(EntityManagerFactory emf) throws NotFoundException, IOException {
            EntityManager em = emf.createEntityManager();
            Continent northAmerica = ContinentFacade.getFacade(emf).getByName("North America");

            Country usa = new Country("USA", northAmerica, "840");
            Country mexico = new Country("Mexico", northAmerica, "484");
            Country canada = new Country("Canada", northAmerica, "124");
            Country guatemala = new Country("Guatemala", northAmerica, "320");
            Country haiti = new Country("Haiti", northAmerica, "332");
            Country cuba = new Country("Cuba", northAmerica, "192");
            Country dominicanRepublic = new Country("Dominican Republic", northAmerica, "214");
            Country honduras = new Country("Honduras", northAmerica, "340");
            Country nicaragua = new Country("Nicaragua", northAmerica, "558");
            Country elSalvador = new Country("El Salvador", northAmerica, "222");
            Country costaRica = new Country("Costa Rica", northAmerica, "188");
            Country panama = new Country("Panama", northAmerica, "591");
            Country jamaica = new Country("Jamaica", northAmerica, "388");
            Country puertoRico = new Country("Puerto Rico", northAmerica, "630");
            Country trinidad = new Country("Trinidad and Tobago", northAmerica, "780");
            Country guadeloupe = new Country("Guadeloupe", northAmerica, "312");
            Country belize = new Country("Belize", northAmerica, "084");
            Country bahamas = new Country("Bahamas", northAmerica, "044");
            Country martinique = new Country("Martinique", northAmerica, "474");
            Country barbados = new Country("Barbados", northAmerica, "052");
            Country stLucia = new Country("St Lucia", northAmerica, "662");
            Country curacao = new Country("Curaçao", northAmerica, "531");
            Country grenada = new Country("Grenada", northAmerica, "308");
            Country stVincent = new Country("St Vincent & the Grenadines", northAmerica, "670");
            Country aruba = new Country("Aruba", northAmerica, "533");
            Country usVirginIslands = new Country("US Virgin Islands", northAmerica, "850");
            Country antigua = new Country("Antigua & Barbuda", northAmerica, "028");
            Country dominica = new Country("Dominica", northAmerica, "212");
            Country caymanIslands = new Country("Cayman Islands", northAmerica, "136");
            Country bermuda = new Country("Bermuda", northAmerica, "060");
            Country greenland = new Country("Greenland", northAmerica, "304");
            Country stKitt = new Country("St Kitts & Nevis", northAmerica, "659");
            Country sintMaarten = new Country("Sint Maarten", northAmerica, "534");
            Country turks = new Country("Turks & Caicos Islands", northAmerica, "796");
            //Country stMartin = new Country("St Martin", northAmerica, "");  // Removed because it's identical to the french flag
            Country britishVirginIslands = new Country("British Virgin Islands", northAmerica, "092");
            //Country caribbeanNetherlands = new Country("Caribbean Netherlands", northAmerica, ""); // Same flag as netherlands
            Country anguilla = new Country("Anguilla", northAmerica, "660");
            Country stBarthelemy = new Country("St Barthélemy", northAmerica, "652");
            Country stPierre = new Country("St Pierre & Miquelon", northAmerica, "666");
            Country montserrat = new Country("Montserrat", northAmerica, "500");

            try {
                em.getTransaction().begin();

                em.persist(usa);
                em.persist(mexico);
                em.persist(canada);
                em.persist(guatemala);
                em.persist(haiti);
                em.persist(cuba);
                em.persist(dominicanRepublic);
                em.persist(honduras);
                em.persist(nicaragua);
                em.persist(elSalvador);
                em.persist(costaRica);
                em.persist(panama);
                em.persist(jamaica);
                em.persist(puertoRico);
                em.persist(trinidad);
                em.persist(guadeloupe);
                em.persist(belize);
                em.persist(bahamas);
                em.persist(martinique);
                em.persist(barbados);
                em.persist(stLucia);
                em.persist(curacao);
                em.persist(grenada);
                em.persist(stVincent);
                em.persist(aruba);
                em.persist(usVirginIslands);
                em.persist(antigua);
                em.persist(dominica);
                em.persist(caymanIslands);
                em.persist(bermuda);
                em.persist(greenland);
                em.persist(stKitt);
                em.persist(sintMaarten);
                em.persist(turks);
                //em.persist(stMartin);
                em.persist(britishVirginIslands);
                //em.persist(caribbeanNetherlands);
                em.persist(anguilla);
                em.persist(stBarthelemy);
                em.persist(stPierre);
                em.persist(montserrat);




                em.getTransaction().commit();
            } finally {
                em.close();
            }



        }
}
