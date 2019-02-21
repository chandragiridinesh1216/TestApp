package com.ibm.webviewloadcontent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    String html = "&lt;header class=\"g-screen__header\"> &lt;p class=\"screen__title\"><strong>HondaLink&lt;sup>&amp;reg;</sup> Terms and Conditions</strong></p> &lt;p class=\"screen__title_sub\">Last updated on January 11, 2019</p> </header>" +
            "&lt;ol class=\"screen__description__list\" style=\"list-style-type: lower-alpha\"> \n" +
            "&lt;li> &lt;p>&lt;em>General&lt;/em>. AcuraLink&lt;sup>&amp;reg;&lt;/sup> gives you access to interactive features and digital services that are intended to enhance your user experience (&amp;ldquo;&lt;strong>Connected Vehicle Services&lt;/strong>&amp;rdquo;). The Connected Vehicle Services may be provided directly by Acura, by Acura&amp;rsquo;s third party service providers (each, a &amp;ldquo;&lt;strong>Third Party Service Provider&lt;/strong>&amp;rdquo;), or by independent third parties (each, an &amp;ldquo;&lt;strong>Independent Provider&lt;/strong>&amp;rdquo;). Not all Connected Vehicle Services are available on all Vehicles and some Connected Vehicle Services are subject to separate terms and conditions (&amp;ldquo;&lt;strong>Connected Vehicle Service Terms&lt;/strong>&amp;rdquo;) in addition to these Terms. For information about Connected Vehicle Services available for your Vehicle, please visit: &lt;em>www.acuralink.acura.com&lt;/em>. If you wish to receive any of the Connected Vehicle Services with separate Connected Vehicle Service Terms, at the time of enrollment or registration, you will be provided with a copy of, and will be required to accept, the applicable Connected Vehicle Service Terms.&lt;/p> &lt;/li>\n" +
            "&lt;li> &lt;p>&lt;em>General&lt;/em>. AcuraLink&lt;sup>&amp;reg;&lt;/sup> gives you access to interactive features and digital services that are intended to enhance your user experience (&amp;ldquo;&lt;strong>Connected Vehicle Services&lt;/strong>&amp;rdquo;). The Connected Vehicle Services may be provided directly by Acura, by Acura&amp;rsquo;s third party service providers (each, a &amp;ldquo;&lt;strong>Third Party Service Provider&lt;/strong>&amp;rdquo;), or by independent third parties (each, an &amp;ldquo;&lt;strong>Independent Provider&lt;/strong>&amp;rdquo;). Not all Connected Vehicle Services are available on all Vehicles and some Connected Vehicle Services are subject to separate terms and conditions (&amp;ldquo;&lt;strong>Connected Vehicle Service Terms&lt;/strong>&amp;rdquo;) in addition to these Terms. For information about Connected Vehicle Services available for your Vehicle, please visit: &lt;em>www.acuralink.acura.com&lt;/em>. If you wish to receive any of the Connected Vehicle Services with separate Connected Vehicle Service Terms, at the time of enrollment or registration, you will be provided with a copy of, and will be required to accept, the applicable Connected Vehicle Service Terms.&lt;/p> &lt;/li>&lt;/ol>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView =  findViewById(R.id.webview);
        String htmlString =  handleEscapeCharacter(html);
        /*Spannable sp = new SpannableString(Html.fromHtml(htmlString));
        Linkify.addLinks(sp, Linkify.WEB_URLS);*/
        StringBuilder sb = new StringBuilder();
        sb.append("<HTML><HEAD><LINK href=\"tnc.css\" type=\"text/css\" rel=\"stylesheet\"/></HEAD><body>");
        sb.append(htmlString);
        sb.append("</body></HTML>");
//        webView.loadData(htmlString, "text/html; charset=utf-8", "utf-8");
        webView.loadDataWithBaseURL("file:///android_asset/", sb.toString(), "text/html; charset=utf-8", "utf-8", null);
    }
    public String handleEscapeCharacter( String str ) {
        String[] escapeCharacters = { "&amp;","&gt;", "&lt;","&ldquo;","&rdquo;", "&quot;", "&apos;"};
        String[] onReadableCharacter = {"&",">", "<", "\"", "\"", "\"", "'"};
        for (int i = 0; i < escapeCharacters.length; i++) {
            str = str.replace(escapeCharacters[i], onReadableCharacter[i]);
        }
        return str;
    }
}
