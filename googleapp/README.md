# 스프링부트 구글 애널리틱스 Sentry.io

## 스프링부트 프로젝트 의존성

- Web
- DevTools
- Mustache

![blog](https://postfiles.pstatic.net/MjAyMDA4MTdfMjk4/MDAxNTk3NjMzOTI3Mzk1.9-unmczch7BphBlEYHnf4Q5dPlWKlpxqPcJnzUKx9qog.uS_IkNcZyvm2E3Q3zL_cYnV-nkdR0gMxd61gABl90HAg.PNG.haha7037/image.png?type=w966)

![blog](https://postfiles.pstatic.net/MjAyMDA4MTdfMTE0/MDAxNTk3NjMzNjk3NjYy.RsxV-m8rTJyAGTKZCbbnrvLK7GDYIa5zLl0pRJgqpJEg.aNJd16p3_vY0q9p2o_EC9Xz8KpUFxnISOaw8IiTnIbgg.PNG.haha7037/image.png?type=w966)

## 구글 애널리틱스

- 파이어베이스에 프로젝트 생성(웹)
- 모든 웹페이지에 footer로 자바스크립트 집어 넣기

```js
	<script src="https://www.gstatic.com/firebasejs/7.18.0/firebase-app.js"></script>

	<script src="https://www.gstatic.com/firebasejs/7.18.0/firebase-analytics.js"></script>

	<script>
	  // Your web app's Firebase configuration
	  var firebaseConfig = {
	    apiKey: "API키",
	    authDomain: "app-35718.firebaseapp.com",
	    databaseURL: "https://app-35718.firebaseio.com",
	    projectId: "app-35718",
	    storageBucket: "app-35718.appspot.com",
	    messagingSenderId: "99529105687",
	    appId: "1:99529105687:web:4a623db34df7db77b55752",
	    measurementId: "G-JDKJDKDW5P"
	  };
	  // Initialize Firebase
	  firebase.initializeApp(firebaseConfig);
	  firebase.analytics();
	</script>
```

## Sentry.io(로그 남기기)

- sentry.io 회원가입
- Settings > Project > 내 프로젝트 이름 > Client keys(DSN) > DSN 확인하기

- Sentry 설정

```java
package com.sunny.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;

@Configuration
public class SentrySupport {

	public SentrySupport() {
		System.out.println("------------------------------------ SentrySuppert init()");
		Sentry.init("DSN");
	}

    public void logSimpleMessage(String msg) {
        EventBuilder eventBuilder = new EventBuilder()
                        .withMessage(msg)
                        .withLevel(Event.Level.ERROR)
                        .withLogger(SentrySupport.class.getName());

        Sentry.capture(eventBuilder);
    }
}
```

- Sentry 실행하는 법

```java
    sentrySupport.logSimpleMessage("product오류 -----");
    sentrySupport.logSimpleMessage("user오류 -----");
```
