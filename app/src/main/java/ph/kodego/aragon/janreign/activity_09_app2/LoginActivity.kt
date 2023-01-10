package ph.kodego.aragon.janreign.activity_09_app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.activity_09_app2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var username: String
    private lateinit var password: String

    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data

        Snackbar.make(
            binding.root,
            "Registered ${data!!.getStringExtra("username")}",
            Snackbar.LENGTH_LONG
        ).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnSubmit.setOnClickListener{
//
//            username = binding.usernametext.text.toString()
//            password = binding.passwordtext.text.toString()
//
//            Snackbar.make(binding.root, "$username - $password", Snackbar.LENGTH_SHORT).show()
//
//            Snackbar.make(binding.root, "SUBMIT",Snackbar.LENGTH_SHORT).show()
//            Toast.makeText(applicationContext, "Submit", Toast.LENGTH_SHORT).show()

        binding.btnRegister.setOnClickListener {

            var goToRegister = Intent(this, RegisterActivity::class.java)
            launchRegister.launch(goToRegister)
        }

        binding.btnForgotpassword.setOnClickListener {

            var goToLogin = Intent(this, ForgotPasswordActivity::class.java)
            launchRegister.launch(goToLogin)
        }

        binding.btnSubmit.setOnClickListener {

            var goToMain = Intent(this, MainActivity::class.java)
            launchRegister.launch(goToMain)
        }
//
//        override fun onBackPressed() {
//            super.onBackPressed()
//        }
    }

}