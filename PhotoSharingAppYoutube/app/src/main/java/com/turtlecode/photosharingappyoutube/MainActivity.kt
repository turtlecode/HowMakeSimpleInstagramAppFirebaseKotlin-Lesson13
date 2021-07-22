package com.turtlecode.photosharingappyoutube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        val current_user = auth.currentUser
        if(current_user != null) {
            val intent = Intent(this,new_activity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun login_onclick (view:View) {
        val email = email_text.text.toString()
        var password = password_text.text.toString()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val current_user = auth.currentUser?.email.toString()
                Toast.makeText(this,"Welcome : ${current_user}", Toast.LENGTH_LONG).show()
                val intent = Intent(this,new_activity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(this,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
    fun register_onclick(view:View) {
        val email = email_text.text.toString()
        var password = password_text.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val intent = Intent(this,new_activity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }
}