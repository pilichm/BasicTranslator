package pl.pilichm.basictranslator

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addOnClickListenersToGridElements()
    }

    /**
     * Adds on click listeners to all grid elements.
     * */
    private fun addOnClickListenersToGridElements(){
        buttonGoodMorning.setOnClickListener(this)
        buttonGoodNight.setOnClickListener(this)
        buttonGoodbye.setOnClickListener(this)
        buttonLetsGo.setOnClickListener(this)
        buttonSeeYouLater.setOnClickListener(this)
        buttonSeeYouTomorrow.setOnClickListener(this)
        buttonPlease.setOnClickListener(this)
        buttonThankYou.setOnClickListener(this)
        buttonImSorry.setOnClickListener(this)
        buttonExcuseMe.setOnClickListener(this)
        buttonHowAreYou.setOnClickListener(this)
        buttonImOk.setOnClickListener(this)
    }

    /**
     * Function for handling playing right audio file for each phrase button.
     * */
    override fun onClick(view: View?) {
        if (mMediaPlayer?.isPlaying == true){
            mMediaPlayer?.stop()
        }

        val audioResource = when (view?.id){
            R.id.buttonGoodMorning -> R.raw.phrase_good_morning
            R.id.buttonGoodNight -> R.raw.phrase_good_night
            R.id.buttonGoodbye -> R.raw.phrase_goodbye
            R.id.buttonLetsGo -> R.raw.phrase_lets_go
            R.id.buttonSeeYouLater -> R.raw.phrase_see_you_later
            R.id.buttonSeeYouTomorrow -> R.raw.phrase_see_you_tomorrow
            R.id.buttonPlease -> R.raw.phrase_please
            R.id.buttonThankYou -> R.raw.phrase_thank_you
            R.id.buttonImSorry -> R.raw.phrase_im_sorry
            R.id.buttonExcuseMe -> R.raw.phrase_excuse_me
            R.id.buttonHowAreYou -> R.raw.phrase_how_are_you
            R.id.buttonImOk -> R.raw.phrase_im_ok
            else -> R.raw.phrase_im_ok
        }

        mMediaPlayer = MediaPlayer.create(applicationContext, audioResource)
        mMediaPlayer!!.start()
    }
}