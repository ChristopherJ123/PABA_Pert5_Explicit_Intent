package guramee.paba.paba_explicit_intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val isiPegawai : ArrayList<Pegawai> = arrayListOf()
    private lateinit var _returnHasil : TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            val selectedItem = result.data?.getStringExtra(
                MainActivity5.SelectedItem
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        isiPegawai.add(Pegawai(1, "Solman", "Data Analyst"))
        isiPegawai.add(Pegawai(2, "Tatik", "Marketing"))

        val _dataKirim = findViewById<EditText>(R.id.dataKirim)
        val _btnExplicit1 = findViewById<Button>(R.id.btnExplicit1)
        val _btnExplicit2 = findViewById<Button>(R.id.btnExplicit2)
        val _btnExplicit3 = findViewById<Button>(R.id.btnExplicit3)
        val _btnExplicit4 = findViewById<Button>(R.id.btnExplicit4)
        _returnHasil = findViewById(R.id.returnHasil)

        _btnExplicit1.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                MainActivity2::class.java
            )
            startActivity(intent)
        }
        _btnExplicit2.setOnClickListener {
            val intentWithData = Intent(
                this@MainActivity,
                MainActivity3::class.java
            ).apply {
                putExtra(MainActivity3.dataTerima, _dataKirim.text.toString())
            }
            startActivity(intentWithData)
        }
        _btnExplicit3.setOnClickListener {
            val intentWithData = Intent(
                this@MainActivity,
                MainActivity4::class.java
            ).apply {
                putExtra(MainActivity4.dataPegawai, isiPegawai)
            }
            startActivity(intentWithData)
        }
        _btnExplicit4.setOnClickListener {
            val intentWithResult = Intent(
                this@MainActivity,
                MainActivity5::class.java
            )
            resultLauncher.launch(intentWithResult)
        }
    }
}