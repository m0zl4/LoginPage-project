package learn.latief.beginningproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var dataEmail : Array<String>
    private lateinit var dataPassword : Array<String>
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail : EditText = findViewById(R.id.edit_email)
        val edtPassword : EditText = findViewById(R.id.edit_password)
        val btnLogin : Button = findViewById(R.id.btnLogin)
        val btnRegister : Button = findViewById(R.id.btnSign)
        progressBar = findViewById(R.id.progressbar)
        val btnForgetPass : TextView = findViewById(R.id.forget)
        val radioRemember : RadioButton = findViewById(R.id.remember)


//        val builder = AlertDialog.Builder(this, R.style.AlertDialog_AppCompat).create()
//        builder.setTitle("Harap isi")
//        builder.setMessage("Tentukan pilihan anda!")
//        builder.setIcon(R.drawable.ic_person)
//        builder.setCancelable(true)
//        builder.show()

        dataEmail = arrayOf("Muhammad", "Abdul", "Latief")
        dataPassword = arrayOf("1234", "4321", "1423")

        btnLogin.setOnClickListener {
            progressBar?.visibility = View.VISIBLE
            signIn(edtEmail.text.toString(), edtPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    fun signIn(email: String, password: String)
    {
        for (i in dataEmail.indices){
            val takeDataEmail = dataEmail.get(i)
            val takeDataPass = dataPassword.get(i)
            if (takeDataEmail == email && takeDataPass == password){
                Toast.makeText(this, "LogedIn", Toast.LENGTH_SHORT).show()
                progressBar?.visibility = View.GONE
                startActivity(Intent(this, HomeActivity::class.java))
                break
            }else{
                Toast.makeText(this, "Akun Slaha", Toast.LENGTH_SHORT).show()
                progressBar?.visibility = View.GONE
            }
        }
    }
}

