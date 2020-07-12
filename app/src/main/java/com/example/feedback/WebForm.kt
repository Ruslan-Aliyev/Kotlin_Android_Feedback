package com.example.feedback

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.fragment.app.Fragment


const val FILECHOOSER_RESULTCODE = 1

class WebForm : Fragment() {

    private lateinit var wvForm: WebView
    //private var mFilePathCallback: ValueCallback<Array<Uri>>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var fragView:View = inflater.inflate(R.layout.webform, container, false)

        wvForm = fragView.findViewById(R.id.wvForm)

        if (18 < Build.VERSION.SDK_INT ) {
            //18 = JellyBean MR2, KITKAT=19
            wvForm.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        }

        wvForm.loadUrl("https://ruslan-website.com/upload/php/contact.html")

        val webSettings: WebSettings = wvForm.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(false)
        webSettings.builtInZoomControls = false
        webSettings.useWideViewPort = true
        webSettings.defaultTextEncodingName = "utf-8"
        webSettings.domStorageEnabled = true
        webSettings.allowFileAccess = true
        webSettings.setAppCacheEnabled(false)
        webSettings.loadWithOverviewMode = true

        wvForm.setPadding(0, 0, 0, 0)

        wvForm.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url!!.startsWith("http:") || url.startsWith("https:")) {
                    view?.loadUrl(url)
                } else if (url.startsWith("tel:")) {
                    val tel = Intent(Intent.ACTION_DIAL, Uri.parse(url))
                    context?.startActivity(tel)
                } else if (url.startsWith("mailto:")) {
                    val urlParts: List<String> = url.split(":")
                    val emailAddress = urlParts[1].split("\\?").toTypedArray()[0]
                    val subject = urlParts[1].split("\\?").toTypedArray()[1].split("=").toTypedArray()[1]
                    Log.i("Email", "$emailAddress $subject")
                    val mailOverride = Intent(Intent.ACTION_SEND)
                    mailOverride.type = "message/rfc822"
                    mailOverride.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
                    mailOverride.putExtra(Intent.EXTRA_SUBJECT, subject)
                    mailOverride.putExtra(Intent.EXTRA_TEXT, "")
                    context?.startActivity(mailOverride)
                }

                return true
            }
            override fun onReceivedError( view: WebView?, request: WebResourceRequest?, error: WebResourceError) {
                super.onReceivedError(view, request, error)
                Log.d("TAG", error.toString())
                // handler.proceed(); This line wont make a different on API 29, Webview still bank
            }
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, er: SslError?) {
                handler.proceed()
            }
        }

//        wvForm.setWebChromeClient(object : WebChromeClient() {
//            override fun onShowFileChooser(webView: WebView, filePathCallback: ValueCallback<Array<Uri>>, fileChooserParams: FileChooserParams): Boolean {
//                // Check no existing callbacks
//                if (mFilePathCallback != null) {
//                    mFilePathCallback.onReceiveValue(null)
//                }
//
//                mFilePathCallback = filePathCallback
//
//                // Set up the intent to get an existing image
//                val i = Intent(Intent.ACTION_GET_CONTENT)
//                i.addCategory(Intent.CATEGORY_OPENABLE)
//                i.type = "image/*"
//
//                mFragment.startActivityForResult(
//                    Intent.createChooser(i, "Image Chooser"),
//                    FILECHOOSER_RESULTCODE
//                )
//
//                return true
//            }
//        })

        wvForm.settings.javaScriptEnabled = true
        wvForm.addJavascriptInterface(JSInterface(context), "Android")

        wvForm.setVisibility(View.VISIBLE)

        return fragView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == FILECHOOSER_RESULTCODE) {
            onHandleFileUploadActivityResult(resultCode, intent)
        } else {
            super.onActivityResult(requestCode, resultCode, intent)
        }

        return
    }

    private fun onHandleFileUploadActivityResult(resultCode: Int, intent: Intent?) {
//        if (null == mFilePathCallback) {
//            return
//        }
//
//        var results: Array<Uri?>? = null
//
//        if (resultCode === Activity.RESULT_OK) {
//            val dataString = intent!!.dataString
//            if (dataString != null) {
//                results = arrayOf(Uri.parse(dataString))
//            }
//        }
//
//        mFilePathCallback.onReceiveValue(results)
//        mFilePathCallback = null
    }
}