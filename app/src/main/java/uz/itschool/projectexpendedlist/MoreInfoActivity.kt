package uz.itschool.projectexpendedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import uz.itschool.projectexpendedlist.databinding.ActivityMoreInfoBinding

class MoreInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user: Countries = intent.getSerializableExtra("user") as Countries
        binding.img.load(user.img) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images.load(user.images) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images2.load(user.images2) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images3.load(user.images3) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.name.text = user.name
        binding.population.text = user.population
        binding.area.text = user.area

    }
}