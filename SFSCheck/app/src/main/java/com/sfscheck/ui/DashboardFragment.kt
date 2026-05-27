package com.sfscheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sfscheck.databinding.FragmentDashboardBinding
import com.sfscheck.engine.NativeLib

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        loadDeviceInfo()
    }

    private fun loadDeviceInfo() {

        try {

            val score = NativeLib.getAuthenticityScore()

            val cpu = NativeLib.getCPUInfo()

            val ram = NativeLib.getTotalRAM()

            val rooted = NativeLib.isRooted()

            binding.scoreText.text =
                "Authenticity Score: ${score}%"

            binding.cpuText.text =
                "CPU Info:\n$cpu"

            binding.ramText.text =
                "RAM: ${ram}MB"

            binding.rootText.text =
                "Rooted: $rooted"

            when {

                score >= 90 -> {

                    binding.statusText.text =
                        "DEVICE ORIGINAL"
                }

                score >= 70 -> {

                    binding.statusText.text =
                        "DEVICE SUSPICIOUS"
                }

                else -> {

                    binding.statusText.text =
                        "POSSIBLE FAKE DEVICE"
                }
            }

        } catch (e: Exception) {

            binding.statusText.text =
                "ERROR LOADING DEVICE INFO"

            binding.cpuText.text =
                e.message
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
