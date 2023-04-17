package com.example.sqliteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var tname:EditText
    private lateinit var temail:EditText
    private lateinit var tidnum:EditText
    private lateinit var btn_save:Button
    private lateinit var btn_view:Button
    private lateinit var btn_delete:Button
    private lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tname = findViewById(R.id.edtname)
        temail = findViewById(R.id.edtemail)
        tidnum = findViewById(R.id.edtidnumber)
        btn_save = findViewById(R.id.btnsave)
        btn_view = findViewById(R.id.btnview)
        btn_delete = findViewById(R.id.btndelete)

//        creating our database
        db = openOrCreateDatabase("nateDB", Context.MODE_PRIVATE, null)

//        creating a table
        db.execSQL("CREATE TABLE IF NOT  EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")


        btn_view.setOnClickListener {
            Toast.makeText(this, "view", Toast.LENGTH_SHORT).show()
        }

        btn_save.setOnClickListener {
            var name_edt = tname.text.toString().trim()
            var email_edt = temail.text.toString().trim()
            var idnum_edt = tidnum.text.toString().trim()

//            validate user statement
            if (name_edt.isEmpty() || email_edt.isEmpty() || idnum_edt.isEmpty())
                Toast.makeText(this, "Check Your Input Fields", Toast.LENGTH_SHORT).show()
            else {
                db.execSQL("INSERT INTO users VALUES('"+name_edt+"', '"+email_edt+"', '"+idnum_edt+"')")

                Toast.makeText(this, "DATA SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

            }
        }

        btn_delete.setOnClickListener {
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show()
        }

    }
}

