package com.example.myapplication


import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var Ten = ""
    private var soluong = 0
    fun ktradulieu(): Boolean{
        if (Ten.isBlank()){
            binding.ten.error = "Vui long nhap ten hop le"
            return false
        }
        if (soluong== null || soluong<=0)
        {
            binding.soLuong.error = "Vui logn nhap so luong hop le"
            return false
        }else
        {
            val phanLoai = if (soluong<5) "it" else "nhieu"
            Toast.makeText(this, "Phan loai: ${phanLoai}", Toast.LENGTH_SHORT).show()
        }

        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnKiemTra.setOnClickListener {
            with(binding){
                Ten = ten.text.toString().trim()?: ""
                soluong = soLuong.text.toString().toIntOrNull()?:-1
            }
            if (ktradulieu() == false){
                Toast.makeText(this, "Vui long kiem tra du lieu hop le", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Da kiem tra thanh cong", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnXoa.setOnClickListener {
            with(binding){
                ten.setText("")
                soLuong.setText("")
                ten.error = null
                soLuong.error = null
                ten.requestFocus()
            }
        }
    }
}