package uz.itschool.projectexpendedlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import uz.itschool.projectexpendedlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var continents: MutableMap<String, MutableList<Countries>>
    private lateinit var continentsTittle: ArrayList<String>
    private lateinit var continentsValues: ArrayList<Countries>
    private var isFav = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()


        val adapter = ContinentAdapter(this, continents, continentsTittle)
        binding.expandable.setAdapter(adapter)
        binding.expandable.setOnGroupClickListener { expandableListView, view, i, l ->
            Log.d("TAG", "Group name: " + continentsTittle.get(i))
            false
        }
        binding.expandable.setOnChildClickListener { _, _, i, i2, _ ->
            val country = continents.get(continentsTittle.get(i))!!.get(i2)
            val intent = Intent(this, MoreInfoActivity::class.java)
            intent.putExtra("user", country)
            startActivity(intent)
            true
        }
        binding.expandable.setOnGroupExpandListener {

        }
        binding.expandable.setOnGroupCollapseListener {

        }
    }

    private fun loadData() {
        continents = mutableMapOf()
        val asia = arrayListOf<Countries>()
        asia.add(
            Countries(
                "Afghanistan",
                "38,93 mln",
                "652,860 km²",
                "https://cdn.britannica.com/40/5340-050-AA46700D/Flag-Afghanistan.jpg",
                "https://udayton.edu/magazine/2021/08/images/2108_afganistan_island.jpg",
                "http://sunnionline.us/english/wp-content/uploads/2021/10/DSC_6696-1024x684-1.jpg",
                "https://cdn.thecrazytourist.com/wp-content/uploads/2017/02/Panjshir-Valley.jpg"
            )
        )
        asia.add(
            Countries(
                "Azerbaijan",
                "10,13 mln",
                "82,658 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Flag_of_Azerbaijan.svg/1200px-Flag_of_Azerbaijan.svg.png",
                "https://bakutravelpackages.com/wp-content/uploads/2021/02/Azerbaijan-Tourism-min-1024x540.jpg",
                "https://www.telegraph.co.uk/content/dam/Travel/2016/August/baku-azerbaijan-travel-ap.jpg",
                "https://www.travelanddestinations.com/wp-content/uploads/2020/08/Azerbaijan-Highlights-Baku-Skyline.jpg"
            )
        )
        continents.put("Asia", asia)


        val africa = arrayListOf<Countries>()
        africa.add(
            Countries(

                "South Africa",
                "59.39 mln",
                "1.22 mln km²",
                "https://cdn.britannica.com/27/4227-050-00DBD10A/Flag-South-Africa.jpg",
                "https://www.nationsonline.org/gallery/South-Africa/Twelve-Apostles-Oudekraal.jpg",
                "https://cdn.kimkim.com/files/a/content_articles/featured_photos/5e127319f07b73e844245fc1e306775d2631d96e/big-34e9cae75b6de8ca7644837b839e89ba.jpg",
                "https://www.roadaffair.com/wp-content/uploads/2017/10/cape-town-south-africa-shutterstock_92510755.jpg"

            )
        )
        continents.put("Africa", africa)


        val europe = arrayListOf<Countries>()
        europe.add(
            Countries(
                "Croatia",
                "4,10 mln",
                "55,960 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/800px-Flag_of_Croatia.svg.png",
                "https://travellersworldwide.com/wp-content/uploads/2022/12/Shutterstock_1935292256.jpg.webp",
                "https://media.cnn.com/api/v1/images/stellar/prod/220908114717-06-alternative-dalmatia-croatia-pula.jpg?c=original&q=w_1280,c_fill",
                "https://cdn.travelpulse.com/images/2aaaedf4-a957-df11-b491-006073e71405/2e2b6be6-9c85-4dc2-b245-8f5b13a64deb/630x355.jpg"
            )
        )
        continents.put("Europe", europe)


        val nAmerica = arrayListOf<Countries>()
        nAmerica.add(
            Countries(
                "Canada",
                "37,74 mln",
                "9,09 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",
                "https://a.cdn-hotels.com/gdcs/production159/d204/01ae3fa0-c55c-11e8-9739-0242ac110006.jpg",
                "https://cdn.britannica.com/93/94493-050-35524FED/Toronto.jpg",
                "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/27000/27764-Moraine-Lake.jpg"
            )
        )
        continents.put("North America", nAmerica)


        val sAmerica = arrayListOf<Countries>()
        sAmerica.add(
            Countries(
                "Brazil",
                "212,55 mln",
                "8,35 mln km²",
                "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png",
                "https://travellersworldwide.com/wp-content/uploads/2022/05/shutterstock_1369316819.jpg.webp",
                "https://www.celebritycruises.com/blog/content/uploads/2021/09/what-is-brazil-known-for-christ-the-redeemer-aerial-hero.jpg",
                "https://cdn.kimkim.com/files/a/content_articles/featured_photos/3158d8afedadf0a7bed038a518068f84f97459dd/big-2f1ff0c0898a4d5eb455c6e85ce30406.jpg"

            )
        )
        sAmerica.add(
            Countries(
                "Argentina",
                "45,19 mln",
                "2,73 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/1200px-Flag_of_Argentina.svg.png",
                "https://cdn.britannica.com/40/195440-050-B3859318/Congressional-Plaza-building-National-Congress-Buenos-Aires.jpg",
                "https://travellersworldwide.com/wp-content/uploads/2022/07/Shutterstock_1371228326.jpg.webp",
                "https://i.natgeofe.com/k/58cfabae-99a5-4df0-992c-b550dd05c57c/argentina-city-night.jpg?w=636&h=358"
            )
        )
        continents.put("South America", sAmerica)


        val australia = arrayListOf<Countries>()
        australia.add(
            Countries(
                "Australia",
                "25,49 mln",
                "7,68 mln km²",
                "https://cdn.britannica.com/78/6078-004-77AF7322/Flag-Australia.jpg",
                "https://a.cdn-hotels.com/gdcs/production5/d1996/54fdb73f-eee5-4612-a3e7-6fc7ed2f7bee.jpg?impolicy=fcrop&w=800&h=533&q=medium",
                "https://www.nationsonline.org/gallery/Australia/Uluru-from-above-MS.jpg",
                "https://i.insider.com/5f3424f2988ee31668198a09?width=700"
            )
        )
        continents.put("Australia", australia)
        continentsTittle = ArrayList(continents.keys)
    }
}