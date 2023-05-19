package com.rakamin.ratestar

import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.RatingBar
import android.widget.Switch
import android.widget.Toast
import com.rakamin.ratestar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            binding.btnSubmit.isEnabled = rating > 0
        }

        binding.btnSubmit.setOnClickListener {
            val rating = binding.ratingBar.rating.toInt()
            if (binding.btnTips.isChecked){
                Toast.makeText(this, "You have give your rate with : $rating stars with tips", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "You have give your rate with : $rating stars without tips", Toast.LENGTH_SHORT).show()
            }
        }
    }
}