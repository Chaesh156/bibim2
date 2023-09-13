import com.google.firebase.FirebaseApp;
import org.eclipse.persistence.platform.database.FirebirdPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class FCMConfig {

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        ClassPathResource resource = new ClassPathResource("firebase/firebase_key.json");

        InputStream refreshToken = resource.getInputStream();

        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();



        if (firebaseApps != null && !firebaseApps.isEmpty())
        {
            for (FirebaseApp app : firebaseApps)
            {
                if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
                    firebaseApp = app;
            }
        }
        else
        {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .build();

            firebaseApp = FirebaseApp.initializeApp(options);
        }


        return FirebaseMessaging.getInstance(firebaseApp);
    }
}