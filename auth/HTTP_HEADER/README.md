# Cookie
- 웹브라우저와 웹 서버간에 상태 정보를 유지하기 위한 기술로 브라우저의 로컬에 저장하고 필요할 때무다 서버에 전송하여 상태를 유지
- HTTP 헤더에 Set-Cookie와 같은 헤더를 통해 서버에서 클라이언트에 전송
- 키-벨류 쌍으로 이루어져 있으며 이름, 값, 유효기간, 도메인, 경로 등의 정보를 포함한다.
- 특징
    - 쿠키는 클라이언트 측에 젖아된다. 따라서 서버가 클라이언트의 상태 정보를 확인하려면, 쿠키를 클라이언트에서 전송받아야합니다.
    - 쿠키는 유효기간을 가지고 있습니다. 유효기간이 지나면, 쿠키는 삭제됩니다.
    - 쿠키는 보안 문제가 있을 수 있습니다. 쿠키에 민감한 정보를 저장하는 경우, HTTPS와 같은 보안 프로토콜을 사용하여 암호화해야합니다.
    - 쿠키는 브라우저에서 관리되기 때문에, 브라우저에서 쿠키를 삭제하거나, 다른 브라우저에서 접속하는 경우에는 쿠키를 공유할 수 없습니다.
- 쿠키를 통한 인증은 많은 곳에서 사용하고 있는 인증방식이다.
    1. 사용자가 로그인 페이지에 접속하여 로그인 정보를 입력한다.
    2. 서버는 사용자 정보를 검증하고, 인증이 성공하면 사용자의 고유 ID와 함께 인증 토큰(쿠키)을 생성한다.
    3. 서버는 생성된 인증 토큰을 HTTP 응답 헤더에 포함하여 클라이언트에게 전송합니다.
    4. 클라이언트는 전송받은 인증 토큰을 로컬에 저장합니다.
    5. 클라이언트는 이후 서버에 요청을 보낼 때마다 인증 토큰을 HTTP 요청 헤더에 포함하여 전송합니다.
    6. 서번느 전송받은 인증 토큰을 검증하여 인증이 성공하면 요