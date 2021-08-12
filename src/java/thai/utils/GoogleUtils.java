/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *{
  "access_token": "ya29.a0ARrdaM_fjJNVxfMLN6oYIH7DT1P3BFmk5RXRMzQDKLDFEU8QrABQF-HruYzyWsVQKguLEc5ovroeMZ5-Q8N3pyVGeL0H7MSC_X72NDLvX8OGuF_mtyuZZWbSCH3xbReURAWhkjLQfGYNdQs9KQ1awAxgakFa",
  "expires_in": 3599,
  "scope": "https://www.googleapis.com/auth/userinfo.email openid",
  "token_type": "Bearer",
  "id_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBmY2MwMTRmMjI5MzRlNDc0ODBkYWYxMDdhMzQwYzIyYmQyNjJiNmMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNDg3MjU5NjY0NzY0LXUwMHQ3ZWJrb21pNGNsaW5rZWJsODJjN2hraTk0NmloLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNDg3MjU5NjY0NzY0LXUwMHQ3ZWJrb21pNGNsaW5rZWJsODJjN2hraTk0NmloLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTAzMDY1NzQwOTU0MDMyMTQ0NTk3IiwiZW1haWwiOiJob2FuZ3RoYWkyMnR2QGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiaWhVdzlOblJpSU9Kd0tFbTUyR29HZyIsImlhdCI6MTYyODA5NTQzMSwiZXhwIjoxNjI4MDk5MDMxfQ.ms_KfVaLQe96YLPSPONyBrAQH9C1puFprT_RyaUcCiel99ANOgz_BLJj3wm29fzsoNIMW8VN3SLsRlIO13LZqW9R-sDnYbGdXqZClbRzekC_WhamR58mQ7fl-ieZZyXCCvB6wYQRilK-iuzyTSvSEh7hnqQud7wC0fnsWsHbUvW7rtaKqMY2n6UVR2omMCwLoMzwnVEmL9oLzPuNYxHIvXApZAsgLkGGDDOM5Nw-01RT-stGTlH-FG1Qrd7nNrpV2pHVniMkhyRZr9aXggocpA02kKxO_e0benqmpOiOc8hDLqnxWAVzbcoS96r73q-wkC1iNNxeTt-0g1Cvtx1FgA"
}{
  "access_token": "ya29.a0ARrdaM9ah9yvy_ExU_ad0vJo7qW1xqaZ4H2LNfInxTsoyLXKOi5eTimAKjEbqHZNNcpbMAQT5iafP5TjxD-BO6f8DV-ZnfXj0ylrGgYQIXVCQFvLv1pxHxHIdwgccd3kKGwdTk8FwUaJCffzmgjcBeFZ-48k",
  "expires_in": 3599,
  "scope": "https://www.googleapis.com/auth/userinfo.email openid",
  "token_type": "Bearer",
  "id_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBmY2MwMTRmMjI5MzRlNDc0ODBkYWYxMDdhMzQwYzIyYmQyNjJiNmMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiMjAwNjg5MjQxNzI3LWhtNHI0czBlbmptMWNlN3RoOHBzOGY1aXA5ajJhMnAyLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMjAwNjg5MjQxNzI3LWhtNHI0czBlbmptMWNlN3RoOHBzOGY1aXA5ajJhMnAyLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTAzMDY1NzQwOTU0MDMyMTQ0NTk3IiwiZW1haWwiOiJob2FuZ3RoYWkyMnR2QGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiczV5eUM2d01VcWZFTnpKeTJJY1NXUSIsImlhdCI6MTYyODA5NTQwOSwiZXhwIjoxNjI4MDk5MDA5fQ.TUAR5GVmRjQY82OmnZRr4U95MPDrsMV87j65R6IFcfeI31jcptf5RZEIJ4004qYDeBNhBS1xX2cGX32Ui77KvcmVaOZfQ1r73jQ0Q_g7pKYfmBYS5Zk-FAp2XylLsgBGrQgijDMv9TM2Fuu33gkPGgS6OsD1YltIF23KlnXnAECQO95mO4fCZ56PDU5PPsLXmw3xoUqtbfU-SkaaPxn3dkBW5ggUzwUJSvXZ6cbiLECg5I9VATpYeHpI1klgGO_ffBI8o73gu2vMxhWvxG6E0b79x6ADKXyY8aCbQpfOLdOw-jAGoxGTaTOSMDdxeeSiL4mOpNLMe3zrQwLT8gfAQw"
}
 * @author ASUS
 */
public class GoogleUtils {

     public static String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
         System.out.println("Constants.GOOGLE_LINK_GET_TOKEN: " + Constants.GOOGLE_LINK_GET_TOKEN);
        System.out.println("rspon"+response );
        JsonObject jobj = new JsonObject();
        Gson gson = new Gson();
        System.out.println("jobj1: " + gson.fromJson(response, JsonObject.class));
        jobj = new Gson().fromJson(response, JsonObject.class);
        System.out.println("jobj2: " + jobj);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
        System.out.println(googlePojo);
        return googlePojo;
    }
}
