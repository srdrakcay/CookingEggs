package com.serdar.cookingeggs.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serdar.cookingeggs.databinding.FragmentHomeBinding
import com.serdar.cookingeggs.notification.Constant.Companion.DESCRIPTION
import com.serdar.cookingeggs.notification.Constant.Companion.TITLE
import com.serdar.cookingeggs.notification.Notification

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.egg1.setOnClickListener {
            timer()
        }
        binding.egg2.setOnClickListener {
            timer()
        }
        binding.egg3.setOnClickListener {
            timer()
        }
        binding.egg4.setOnClickListener {
            timer()
        }
        binding.egg5.setOnClickListener {

            timer()
        }
    }

    private fun timer(){
        // add different time for the eggs
        object : CountDownTimer(15000,1000)
        {

            override fun onTick(p0: Long)

            {
                binding.timer.text = "Kalan: ${p0 / 1000}"
            }

            override fun onFinish() {
                binding.timer.text = "Your egg is ready now"
                Notification.timerNotification(requireContext(), TITLE,DESCRIPTION)
            }

        }.start()
    }
}