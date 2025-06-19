package vcmsa.ci.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
// declared and intialised the arrays
    private val songname = arrayOf<String>()
    private val artistname = arrayOf<String>()
    private val ratings = arrayOf<Int>()
    private val comments = arrayOf<String>()
    private val maxSize = 3
    // used methods to declare variables
    private lateinit var edtSong: EditText
    private lateinit var edtArtist: EditText
    private lateinit var edtRating: EditText
    private lateinit var edtComment: EditText
    private lateinit var btnReview: Button
    private lateinit var btnAdd: Button
    private lateinit var  btnExist : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        edtSong = findViewById(R.id.edtSong)
        edtArtist = findViewById(R.id.edtArtist)
        edtRating = findViewById(R.id.edtRating)
        edtComment = findViewById(R.id.edtComment)
        btnAdd = findViewById(R.id.btnAdd)
        btnReview = findViewById(R.id.btnReview)
        btnExist = findViewById(R.id.btnExist)

        // used the add button to display the edit texts
        btnAdd.setOnClickListener {
            val song = edtSong.text.toString()
            val artist = edtArtist.text.toString()
            val rate = edtRating.text.toString()
            val comment = edtComment.text.toString()

            if (
                song.isBlank() && artist.isBlank() && rate.isBlank() && comment.isBlank())
            {
                Toast.makeText(this,"PLEASE FILL ALL FIELDS PROVIDED!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val rating = rate.toIntOrNull()
            if (rating != null) {
                if

                        (rating == null && rating < 1) {
                    Toast.makeText(this, "PLEASE ENTER A VALID NUMBER!!!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            if (
                songname.size > maxSize || artistname.size > maxSize || ratings.size > maxSize || comments.size > maxSize

            ){
                add(songname)
                add(artistname)
                add(ratings)
                add(comments)
            }
            // next screen
            btnReview.setOnClickListener {
                val intent = Intent(this,detailedViewScreen::class.java)
                intent.putExtra("Song",songname)
                intent.putExtra("Artist",artistname)
                intent.putExtra("Rate",ratings)
                intent.putExtra("Comment",comments)
                intent.putExtra("max",maxSize)

                startActivity(intent)
            }
            btnExist.setOnClickListener {
                finish()
            }
        }




    }

    private fun add(ratings: Array<Int>) {

    }
}

private fun add() {

}

private fun add(ratings: Array<String>) {

}







