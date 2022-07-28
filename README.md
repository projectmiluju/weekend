 
<img src="https://github.com/projectmiluju/weekend/blob/master/UML.PNG" width="1000" alt="USECASE그려보기"></img>

-[API명세서](https://github.com/projectmiluju/TIL/tree/main/202207/20220726)

1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)   
>param을 사용해 id를 포함한 요청을 보내 @PathVariable 통해 받았습니다. 

2. 어떤 상황에 어떤 방식의 request를 써야하나요?
>param
>> 서버에 존재하는 리소스를 지정할 때 사용합니다. 결과가 존재하지 않는다면 오류, 404 리턴을 줄 수 있습니다.
> 
>query
>> 특정한 조건에 맞는 리소스를 요청할 때 사용합니다. 결과가 존재하지 않아도 정상, 200 리턴을 줄 수 있습니다.
>
>body
>> 데이터를 서버에 저장하거나 서버로부터 받아오는 경우 사용합니다.

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요? 
>생성 요청에는 Post, 조회 요청에는 Get, 수정 요청에는 Put, 삭제 요청에는 Delete 메서드를 사용    
>RESTful한  Api를 구현하려고 노력했습니다.

4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

>Controller__ - 클라이언트의 요청을 받고 응답을 생성하여 처리된 결과를 리턴하도록 구현했습니다. 
>Repository__ - 데이터베이스와 데이터를 주고받는 기능을 구현했습니다.   
>Service__ - 요청으로 받아온 데이터를 요구사항에 맞게 처리하는 로직을 담당하도록 구현했습니다.

5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요!
>postController
>postRepository
>postService
>weekendApplication

6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!
>요청 변수의 상세한 정보, 기능 구분, 필수 여부 등과 같은 내용들이 부족했습니다.
