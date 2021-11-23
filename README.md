# "송파 코딩 온/오프 스터디" 에서 사용할 커뮤니티 애플리케이션 

### 프로젝트 개요

- 스터디 모임 일정을 잡거나 그날 스터디를 공유하고 서로 댓글을 달며 의견을 공유할 수 있는 자율 게시판입니다.
- 우선은 게시판을 먼저 배포까지 진행하고, 추후 구조를 msa구조로 변환을 진행하여 필요한 기능들을 하나씩 추가로 확장해갈 예정입니다.

### 프로젝트 목적

- 모놀리스 구조부터 시작해서 차근차근 깊이있게 팀원들과 학습도하고 힘든 취업/이직을 준비함에 있어 같이 성장하고자 진행하게되었습니다.
- 처음부터 너무 거창한 목표로 진행하기보단 단순 게시판이지만 저희 모임에 꼭 필요한 기능을 중심으로 차근차근 깊이 있게 진행중입니다.

### 진행방향 : 1단계

- 아키텍처 - 모놀리스
- 사용기술 및 도구 
  - 백엔드 : java, spring boot(jpa, lombok, spring-security, jwt, junit4)
  - 프론트 : mustache, javascript, css, bootstrap, jQuery(ajax만 사용)
  - 데이터베이스 : mysql, h2
  - 툴 : intellij
  - 배포 :  aws ec2
- 구조

<img src="https://ifh.cc/g/nTSefC.png" alt="l3-switch" style="zoom:80%;" />

➡️ 현재 구조에서 크게 "인증/인가" 기능을 하는 welcome패키지와 board패키지가 존재합니다.

➡️ 특이한점은 각각 controller, service, domain, repository, dto를 가진다. 이렇게 구조를 잡은 이유는 2단계에서 우리의 서비스를 msa로의 진행시 분할하기 쉽게하기 위함이다. 즉, welcome과 board는 각각 개별 서비스 인스턴스가 될것입니다.

➡️ 또 컨트롤러안을 보면 현재 프론트엔드가 Single Page Application(SPA)구조가 적용되지 않아 페이지 이동이 필요하게되어 단순 페이지 이동을 담당하는 일반 컨트롤러인 WelcomeController와 로그인, 회원가입 등 기능적인 부분의 요청을 담당하는 'Rest' 키워드가 들어간 LoginRestController가 존재한다. 'Rest' 키워드가 들어간 컨트롤러는 기능 요청을 처리하고, 그냥 Controller는 페이지 이동을 처리합니다.

<img src="https://ifh.cc/g/2ojwnT.png" alt="l3-switch" style="zoom:80%;" />

