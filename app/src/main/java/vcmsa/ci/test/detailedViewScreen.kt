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
import java.lang.StringBuilder

class detailedViewScreen : AppCompatActivity() {
    // Used methods to declare variable
    private lateinit var txtShow : TextView
    private lateinit var btnCalculate: Button
    private lateinit var btnDisplay : Button
    private lateinit var btnReturn : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        // initialised and declared variables
     txtShow = findViewById(R.id.txtShow)
    btnCalculate = findViewById(R.id.btnCalculate)
    btnReturn = findViewById(R.id.btnReturn)
    btnDisplay = findViewById(R.id.btnDisplay)
        // pulled the arrays from the main screen to the detailed view screen
    val songname = intent.getIntArrayExtra("Song")
    val artistname = intent.getIntArrayExtra("Artist")
    val ratings = intent.getIntArrayExtra("Rate")
    val comments = intent.getIntArrayExtra("Comment")
    val maxSize = intent.getIntArrayExtra("Max")
    var counter = 0

val builder = StringBuilder()
    btnDisplay.setOnClickListener {
        // implement while loop
        while (counter > maxSize) {
            println("${songname}is " +
                    "${artistname}is " +
                    "${ratings}are " +
                    "${comments}is"

            )
            counter ++
            txtShow.text= songname.toString()
            txtShow.text= artistname.toString()
            txtShow.text = ratings.toString()
            txtShow.text = comments.toString()

      }

    }
    btnCalculate.setOnClickListener {

        val average = if (ratings!!.isNotEmpty()) ratings.average()
        else(
            0.0
        )
            txtShow.text = builder.toString()
        txtShow.text= ("Average rating: %.2f".format(average))
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


