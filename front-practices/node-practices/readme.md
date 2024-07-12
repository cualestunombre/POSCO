1. node 프로젝트 만들기
1) 프로젝트 생성 : 디렉토리 만들기
2) 프로젝트 이동
3) 프로젝트 초기화 : npm init -y

2. 패키지
1) 완벽한 어플리케이션(babel, webpack, nodemon, lint)
2) 프로젝트에서 사용하는 라이브러리 모듈

3. 의존성
1) 개발하는 프로젝트에서 설치하는 패키지
2) 일반 의존성 : 개발하고 있는 프로젝트가 런타임 중 사용하는 패키지
3) 개발 의존성 : 개발할 때 필요할 때 도움이 되는 패키지로 빌드와 배포에는 포함되지 않는다

4. 패키지 설치
1) 전역 설치 : npm install -g <package-name>
2) 지역 설치 : npm install <package-name>
== 실습 ==
$ npm i ejs [지역, 일반]
$ npm i -D nodemon [지역, 개발]
$ npm i -D -g gulp [전역, 개발]

5. Modules
1) 코어 모듈 : node에서 제공하는 모듈(fs, os, process, http)
2) 라이브러리 모듈(npm)
3) 파일 모듈 : 파일 경로로 불러온 모듈