package com.example.intentactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentactivity.databinding.ActivityMainBinding
import com.example.intentactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val SecondActivity = "MainActivity"
    private lateinit var binding: ActivitySecondBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val data = result.data
                val address = data?.getStringExtra("EXTRA_ADDRESS")
                binding.textViewAlamat.setText(address)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d(SecondActivity, "onCreate dipanggil2")

        binding =ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("EXTRA_NAME")
        with(binding) {
            textNameView.setText(name)
            btnToThirdActivity.setOnClickListener {
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                launcher.launch(intent)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d(SecondActivity, "onResume dipanggil2")
    }

    override fun onPause() {
        super.onPause()
        Log.d(SecondActivity, "onPause dipanggil2")
    }

    override fun onStart() {
        super.onStart()
        Log.d(SecondActivity, "onStart dipanggil2")
    }

    override fun onStop() {
        super.onStop()
        Log.d(SecondActivity, "onStop dipanggil2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(SecondActivity, "onDestroy dipanggil2")
    }
}