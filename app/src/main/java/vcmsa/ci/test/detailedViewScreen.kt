package vcmsa.ci.test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailedViewScreen : AppCompatActivity() {
    private lateinit var txtShow : TextView
    private lateinit var btnCalculate: Button
    private lateinit var btnDisplay : Button
    private lateinit var btnReturn : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

     txtShow = findViewById(R.id.txtShow)
    btnCalculate = findViewById(R.id.btnCalculate)
    btnReturn = findViewById(R.id.btnReturn)
    btnDisplay = findViewById(R.id.btnDisplay)
    val songname = intent.getIntArrayExtra("Song")
    val artistname = intent.getIntArrayExtra("Artist")
    val ratings = intent.getIntArrayExtra("Rate")
    val comments = intent.getIntArrayExtra("Comment")
    val maxSize = intent.getIntArrayExtra("Max")
    var counter = 0


    btnDisplay.setOnClickListener {
        txtShow.text= songname?.size.toString()
        txtShow.text= artistname?.size.toString()
        txtShow.text = ratings?.size.toString()
        txtShow.text = comments?.size.toString()
        while (counter > maxSize) {
            println("${songname}is " +
                    "${artistname}is " +
                    "${ratings}are " +
                    "${comments}is"

            )
            counter ++  }

    }
    btnCalculate.setOnClickListener {
        val average = ratings?.average()
        println("Average : $average")
    }

    btnReturn.setOnClickListener {
        intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}






}

private operator fun Number.compareTo(size: IntArray?): Int {
//
    return TODO("Provide the return value")
}


