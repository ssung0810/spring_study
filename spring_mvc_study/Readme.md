## 들어가기에 앞서

자바 개발자로서 Spring을 당연하게 사용하고있다. 하지만 Spring이 어떻게 동작하는지를 정확히 이해하고 사용하고 있지는 않다. 이 프로젝트는 항상 사용하는 스프링MVC가 어떤 구조로 돌아가는지 요청의 흐름이 어떻게 처리되는지를 이해하기 위한 프로젝트이다.

<br>

스프링MVC의 구조를 쫒아가는 학습이다보니 SpringMVC를 사용해봤지만 그 구조에 대해서 아직 제대로 이해하지 못하는 사람이 학습하기에 좋은 내용이라고 생각한다.

<br>

지금은 바야흐로 HTTP의 세상이다. 거의 모든 통신을 HTTP를 이용한 통신이라고 해도 과언이 아닐 정도이다. 이런 환경속에서 HTTP의 데이터를 쉽게 받고 보내줄 수 있도록 만들어진 것이 서블릿이다. 이 서블릿이 가장 기본이 되어서 서블릿부터 점차 발전되어가는 과정들을 학습해 갈 것이다.

<br>

프로젝트는 SpringBoot를 사용해서 진행하지만 라이브러리 관리와 세팅의 편의성을 위해서 사용하는 것이고 SpringBoot의 기능을 사용하지는 않고 진행한다.

<br>

<br>

## 학습내용

전체적인 목차는 다음과 같다.

- 서블릿을 만들어보고 이해해보기
- 서블릿과 JSP를 이용한 페이지 호출
- MVC패턴의 시작
- 프론트 컨트롤러와 view의 분리
- 서블릿 종속성 제거, Model분리
- 어댑터 패턴을 활용한 유연한 컨트롤러

<br>

이러한 순서로 차례대로 프로젝트를 진행하고 학습할 수 있는 내용이다.

프레임워크는 한번에 완성되는 것이 아니다. 처음시작은 작고 초라하게 시작할 수 있지만 불편함들을 조금씩 개선하고 발전시키면서 최종적으로 지금 우리가 사용하고있는 Spring의 모습이 완성되는 것이다. 그 과정들을 하나씩 경험해보고 이후에 어떻게 확장되고 변화될 수 있을지도 생각해 볼 수 있을 것이다.

<br>

학습에 대한 자세한 내용은 블로그에 올려놨으니 블로그를 참고하면서 코드작성과 내용이해의 도움을 받으면 좋을것이다.

<br>
<br>
<br>
<br>

	
스프링 MVC 밑바닥부터 만들어보기1 - 서블릿 탐구하기 <br>
https://solidbasics.tistory.com/22
<br>
	
스프링 MVC 밑바닥부터 만들어보기2 - 서블릿과 JSP <br>
https://solidbasics.tistory.com/23
<br>

스프링 MVC 밑바닥부터 만들어보기3 - MVC패턴의 시작 <br>
https://solidbasics.tistory.com/24
<br>

스프링 MVC 밑바닥부터 만들어보기4 - 프론트 컨트롤러와 view의 분리 <br>
https://solidbasics.tistory.com/25
<br>

스프링 MVC 밑바닥부터 만들어보기5 - 서블릿 종속성 제거, Model분리 <br>
https://solidbasics.tistory.com/26
<br>
	
스프링 MVC 밑바닥부터 만들어보기6 - 어댑터 패턴을 이용한 유용한 컨트롤러 <br>
https://solidbasics.tistory.com/27