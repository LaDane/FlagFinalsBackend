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
        // North America
        // Africa
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
        Country israel = new Country("Israel", asia, "736");
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
        Continent southAmerica = ContinentFacade.getFacade(emf).getByName("South America");

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
        Continent oceania = ContinentFacade.getFacade(emf).getByName("Australia");

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
}
