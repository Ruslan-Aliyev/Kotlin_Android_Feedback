# Feedback

## WebView online contact form
- https://stackoverflow.com/questions/47872078/how-to-load-an-url-inside-a-webview-using-android-kotlin?fbclid=IwAR0mX2S2Ub_YY8wjxc57YLzXrHWae_ZILnxd8qYgDfFUfyXulwj63CieJPg
- https://github.com/Ruslan-Aliyev/Travel-Blog-Android/blob/master/app/src/main/java/com/ruslan_website/travelblog/ContactContentFragment.java
    - https://github.com/Ruslan-Aliyev/Travel-Blog-Android/blob/master/app/src/main/java/com/ruslan_website/travelblog/utils/webview/WebviewHandler.java

### Commonly encountered errors
- https://stackoverflow.com/questions/30637654/android-webview-gives-neterr-cache-miss-message
- https://stackoverflow.com/questions/57131662/err-access-denied-in-webview-in-android/57131848

### Related
- https://gauntface.com/blog/2014/10/17/what-you-need-to-know-about-the-webview-in-l
- https://developer.android.com/guide/webapps/webview#UsingJavaScript

### URL
https://ruslan-website.com/upload/php/contact.html

```html

	<div class="container">

		<h1 class="row">Contact</h1>

		<div class="row">
			<p>
				<a href="tel:+642108241461">Phone us directly</a> 
			</p>
		</div>

		<div class="row">
			<p>
				<a href="mailto:ruslan_aliyev_@hotmail.com?Subject=Travel%20Blog" target="_top">Email us directly</a>
			</p>
		</div>

		<div class="row">
			<form enctype="multipart/form-data" method="POST" action="process_contact.php">
			    <input type="text" name="sender_name" placeholder="name" class="form-control" />
			    <input type="email" name="sender_email" placeholder="email" class="form-control" /> 
			    <input type="text" name="subject" placeholder="subject" class="form-control" />
			    <textarea name="message" placeholder="message" class="form-control"></textarea>
			    <input type="file" name="my_file" class="form-control" />
			    <input type="submit" name="button" value="Submit" class="form-control" />
			<input type="button" onclick="goBack('Back to Entries View')" value="Back" class="form-control" />
			</form>
		</div>

	</div>

	<script>
		function goBack(msg){
			Android.goBack(msg);
		}
	</script>

```

## Email

### Using phone's mail directly
- https://www.tutorialspoint.com/android/android_sending_email.htm?fbclid=IwAR3p1Evq7UviRaV9dm7ua41i3hGqZBDi9dRsY3XFPfv-hX1EXpp31C3h0T8
- https://www.javatpoint.com/how-to-send-email-in-android-using-intent

### Email from custom form
- https://devofandroid.blogspot.com/2018/11/send-email-using-intent-android-studio.html
- https://github.com/Ruslan-Aliyev/Travel-Blog-Android/blob/master/app/src/main/java/com/ruslan_website/travelblog/utils/email/Mail.java
