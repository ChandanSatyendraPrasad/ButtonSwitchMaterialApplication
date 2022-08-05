package chandan.satyendra.prasad.buttonswitchmaterialapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    lateinit var buttonClick: Button
    lateinit var switchMat: SwitchMaterial
    lateinit var textUserName: EditText
    lateinit var textTitle: TextView
    lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        myactivity_addCallbacks()
    }

    private fun myactivity_addCallbacks() {
        switchMat.setOnCheckedChangeListener { compoundButton, b ->
            buttonClick.isEnabled = b
        }
        buttonClick.setOnClickListener {
            showMessage()
            updateTitle()
            updateColor()
            updateLogo()
        }
    }

    private fun updateLogo() {
        val mIcon = ContextCompat.getDrawable(this, R.drawable.logo)
        img.setImageDrawable(mIcon)
    }

    private fun updateColor() {
        val purple = ContextCompat.getColor(this, R.color.purple_200)
        textTitle.setBackgroundColor(purple)
    }

    private fun updateTitle() {
        textTitle.text = getString(R.string.my_name)
    }

    private fun showMessage() {
        val msg = textUserName.text.toString()
        if (msg.isBlank()) {
            Toast.makeText(applicationContext, "Text is empty", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }

    private fun initView() {
        buttonClick = findViewById(R.id.btn_click)
        switchMat = findViewById(R.id.switch_username)
        textUserName = findViewById(R.id.text_username)
        textTitle = findViewById(R.id.txtTitle)
        img = findViewById(R.id.logo)
    }
}