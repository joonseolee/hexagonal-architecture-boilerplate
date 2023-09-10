# hexagonal-architecture-boilerplate

헥사고날 아키텍처를 참고하여 만든 보일러플레이트이다.  

## 구조

* adapter
  * 외부에서 사용하는 모듈들의 가장 외부에서 사용되는 모듈 
* adapter-model
    * adapter 와 application 에서 사용되는 model 들의 집합 모듈
* application
  * adapter 에 있는것과 domain 에 있는것을 연결하는 모듈
* domain
  * 실질적으로 사용되는 도메인 객체들이 모여있는 모듈
* infrastructure
  * 헥사고날 아키텍처를 구성하는 annotations 또는 validations 가 포함된 모듈