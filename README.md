# Android

### DGSW-Smart-Farm Android



#### 팀원

- 담당 선생님
  - 김승호 선생님

- 안드로이드
  - 임재현
  - 지민혁
  - 서민교
  - 조주영
- IOS
  - 김부성
- Server
  - 서승우
  - 박준홍
- 하드웨어
  - 전아현
  - 김지훈



#### 사용기술

- Kotlin
- Retrofit2
- Android JetPack(LiveData, DataBinding)
- dinuscxj circleprogressbar(원형그래프 라이브러리)
- SpannableStringBuilder, NumberPicker, SwipeRefreshLayout 등



#### 날짜 별 진행 사항 (안드로이드 및 스마트팜 전체적 진행 사항)

- 3월 10일 - 아이디어 구체화 / github Organizations 만들기
- 3월 17일 - 디자인 만들기 / 로고 만들기 (일러스트 사용해서 만들었음) / 기능 구체화
- 3월 24일 - 디자인 완성 / UX 이미지 (펜툴로 따기) / 로딩 화면 구현
- 3월 31일 - 메인화면 xml 만들기 / 하드웨어 부품 구매 목록 작성
- 4월 7일 - 디자인 변경으로 xml 처음부터 다시 만들기 / 회식 / 하드웨어 구매 목록 정리
- 4월 14일 - 메인 화면 xml 추가
- 4월 21일 - 수분 상세 화면, LED 상세 화면 xml 완성
- 5월 12일 - 온도 상세 화면, Retrofit으로 서버 통신 완료(GET), 코드 리팩토링(livedata, databinding 사용)
- 5월 26일 - 새로고침 기능 추가, 원형 그래프 디자인 변경, 상세 화면 상태 별 글씨 수정, 프로파일 조립
- 6월 2일 - readme 작성, 오류 수정(ViewModel 오류, 빌드 시 오류 등)
- 6월 9일 - retrofit Post 완료 (안드로이드 개발 완료🔥)



#### 완성된 스마트팜 Application (Android)

- 메인 화면 (재현)

  ![메인 화면](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210611195803133.png)

- 수분 상세 화면 (재현)

  - 수분 상세 현황

    ![수분 상세 현황](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210611195832328.png)

    

  - 물주기

    ![물주기](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210611195911942.png)

    



- 온도 상세화면 (주영)

  ![image-20210611200019378](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210611200019378.png)

  

- LED 상세 화면 (민혁)

  ![image-20210611200043688](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210611200043688.png)

  

- 비료 상세 화면 (민교)

  ![image-20210611200108842](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210611200108842.png)



#### 스마트팜을 개발하면서 힘들었던 점

- 글씨를 부분별로 굵게 하고 싶어요

  ![figma 디자인](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210602153508975.png)

  이렇게 "수분이 적당해요",  "정말 추운날 입니다..." 등 상세화면 페이지에 이런 식으로 굵게 되어있는 부분이 있었는데, 한 번도 해보지 않았던 부분이라 어떻게 처리해야 할지에 대한 고민이 생겼습니다. 구글링을 해보면서 SpannableStringBuilder라는 것을 알게 되었고 여러 글들을 보며 공부하고 실제로 사용해보았습니다.

  ![spannable](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210602153912902.png)

  

- 프로젝트 시작 후 잦은 디자인 변경

  처음 프로젝트를 시작할 때 디자인을 구상하여 figma에서 디자인을 제작한 후 개발을 시작했는데 1주일이 지나고 나니 디자인이 완전히 다르게 변경되어 xml을 다시 제작하는 일이 발생하고, 바뀐 디자인에서도 디자인이 크게 변경되는 부분들이 있었습니다. 프로젝트를 시작한 지 초기 단계라 그런지 디자인 변경이 좀 잦았는데 처음에는 디자인 변경으로 혼란스럽긴 했지만 시간이 지나고 디자인이 완벽하게 확정되면서 개발을 수월하게 진행할 수 있어 좋았습니다.

  ![확정된 Figma 디자인 페이지](C:\Users\USER\AppData\Roaming\Typora\typora-user-images\image-20210602154748244.png)

  

- 협업과 git

  안드로이드 개발은 위에 있는 디자인에서 수분, 온도, 햇빛, 비료 상세화면들을 각각 1개씩 맡아 개발을 진행했습니다. github repository에서 main과 develop 브랜치를 나누고, develop 브랜치에서 branch를 나눠 PR을 보내고 marge 했는데, git을 사용하면서 실수로 main에 PR을 보냈는데 실수로 marge 하거나, marge를 했는데 문제가 발생하는 부분들도 있었습니다.

  평소에는 혼자 github를 쓸 때가 많아서 이런 일을 잘 겪어 보지 못했었지만 여러 명이서 개발을 하다 보니 문제가 발생하는 것을 보면서 당황하게 되었는데 혼자서 고민하며 문제들을 해결하다 보니 또 문제가 발생했을 때에는 능숙하게 해결할 수 있었던 것 같습니다.😁😁

  

- 처음 사용하는 라이브러리들

  디자인에 원형 그래프와 수분 상세화면과 LED 상세화면에 있는 on/off 과 같은 기능들을 사용해본 적이 없어 구현할 수 있을지에 대한 고민들을 했었습니다. 다행히 스마트팜 ios를 개발한 부성이가 라이브러리가 있다고 알려주고 android를 개발한 민교가 라이브러리를 사용해서 만든 것을 보여줘서 수월하게 만들 수 있었습니다.

  또 on/off 기능은 구글링을 계속해보면서 numberPicker를 커스텀 해서 사용할 수 있다는 것을 알게 되었고, 다른 사람들이 만들어 블로그에 올려놓은 예시를 보면서 어떤 식으로 쓰는지 감을 익히고 프로젝트에 사용했습니다.

  위의 기능 말고도 프로젝트를 진행하면서 여러 부분에서 막힘이 존재했지만 스마트팜 팀원과 선생님, 그리고 안드로이드를 하고 있는 친구들에게 물어가면서 잘 마무리할 수 있었습니다.

  

- 갑작스럽게 생겨난 버그들

  개발을 하다 보니 버그들이 발생습니다. layout에서 스크롤 뷰가 먹히지 않는 오류와 LiveData에서 1분 전 까지 되던 코드가 문제가 발생하는 등 방금 말한 버그들 말고도 여러 버그들이 작게 발생했습니다. 그 중에서 가장 생각나던 버그는 앞에서 말한 retrofit에서 LiveData로 값을 넣을 때 생긴 오류였습니다.

  분명 잘 되던 코드였는데 다른 팀원이 맡은 상세 화면을 github에 marge 시키고 pull을 하니 갑작스럽게 발생한 오류였는데 거의 1시간 30분이 걸려 해결했는데, 

  ```kotlin
  MainViewModel.waterStateValue.value = response.body()?.humidityGnd?.value
  ```

  코드에서 MainViewModel을 뺀

  ``` kotlin
  waterStateValue.value = response.body()?.humidityGnd?.value
  ```

  이런 식으로 코드를 고치니 바로 해결 되었습니다. LiveData를 공부하고 프로젝트에서 써본 적이 처음이라 발생했던 실수였던 것 같습니다.😅😅



### 느낀 점

 약 3달에 걸쳐 스마트팜 android part를 완성시켰는데 어렵다고 생각하는 부분들이 프로젝트를 진행하며 조금 많았는데, 그 때마다 구글링이나 선생님, 안드로이드를 하는 친구들에게 도움을 받았는데 이렇게 힘들게 배우다보니 얻는 것이 많았던 시간이었던 것 같습니다.

처음에 나르샤를 진행한다고 했을 때 어떤 팀에 들어가서 개발을 해야할 지 고민이 많았었는데, 다행히 스마트팜 팀에 들어와서 화목하고 재미있게 개발을 할 수 있어 좋은 선택을 한 것 같아 만족스럽습니다.

약 3달동안 함께 개발한 서버 개발을 맡은 승우와 준홍이, 하드웨어 개발을 맡은 아현이와 지훈이, ios를 혼자 개발한 부성이, 디자인을 열심히 해준 동현이, 안드로이드 개발에 민교, 민혁이, 주영이 모두 수고 많았어~😊😊 스마트팜 팀에서 서버면 서버, 모바일이면 모바일, 하드웨어면 하드웨어, 모든 분야에서 조언해주시고 도움을 주신 김승호 선생님도 감사합니다~~😁😁

3달 동안 스마트팜 팀에서 많이 배우고, 느낄 수 있었던 시간이었던 것 같습니다.🎈🎈
