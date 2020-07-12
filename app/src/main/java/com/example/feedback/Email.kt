package com.example.feedback

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class Email : Fragment(), View.OnClickListener {

    private lateinit var recipientEt: EditText
    private lateinit var subjectEt: EditText
    private lateinit var messageEt: EditText
    private lateinit var sendEmailBtn: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var fragView:View = inflater.inflate(R.layout.email, container, false)

        recipientEt = fragView.findViewById(R.id.recipientEt)
        subjectEt = fragView.findViewById(R.id.subjectEt)
        messageEt = fragView.findViewById(R.id.messageEt)
        sendEmailBtn = fragView.findViewById(R.id.sendEmailBtn)
        sendEmailBtn.setOnClickListener(this)

        return fragView
    }

    override fun onClick(v: View?) {
        val recipient = recipientEt.text.toString().trim()
        val subject = subjectEt.text.toString().trim()
        val message = messageEt.text.toString().trim()

        sendEmail(recipient, subject, message)
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }
    }
}