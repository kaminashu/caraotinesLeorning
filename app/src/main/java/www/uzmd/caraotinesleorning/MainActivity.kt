package www.uzmd.caraotinesleorning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import www.uzmd.caraotinesleorning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.dowlandBtn.setOnClickListener {
            lifecycleScope.launch {
                loadProgress()
            }
        }
    }

    private suspend fun loadProgress() {
        binding.progressBar.isVisible = true
        binding.dowlandBtn.isEnabled=false
        val salom = load()
        binding.dowlandBtn.isEnabled=true
        binding.progressBar.isVisible = false
        binding.textView.text = salom
    }

    private suspend fun load(): String {
        delay(2000)
        return "salom"
    }

}