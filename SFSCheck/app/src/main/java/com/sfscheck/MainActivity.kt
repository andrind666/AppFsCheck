package com.sfscheck

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sfscheck.databinding.ActivityMainBinding
import com.sfscheck.engine.NativeLib

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val score = NativeLib.getAuthenticityScore()

        val cpu = NativeLib.getCPUInfo()

        val ram = NativeLib.getTotalRAM()

        val rooted = NativeLib.isRooted()

        binding.scoreText.text =
            "Authenticity Score: $score%"

        binding.cpuText.text =
            "CPU:\n$cpu"

        binding.ramText.text =
            "RAM: ${ram}MB"

        binding.rootText.text =
            "Rooted: $rooted"
    }
}
