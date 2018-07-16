### 참석인원
- 출석표 참조

### 장소 및 비용
- 스터디룸 모임, 31,000

## 진행내용
### git 기초 사용법
- git clone <remote_url>: 서버 레파지토리에서 로컬로 레파지토리를 다운받음
- git fetch: 서버(remote)의 변경사항을 받아옴
- git pull <remote_name> <branch_name>: 서버의 변경사항을 로컬에 적용함
  - remote_name은 보통 origin 사용
- git commit -m <commit message>: 로컬의 변경내용을 로컬 레파지토리에 커밋(서버에 반영안됨)
  - m 은 메세지를 적겠다는 옵션. m 빼고 git commit 만 하면 메세지적는 창이 한번 더 뜸
- git push <remote_name> <branch_name>: 로컬의 변경사항을 서버에 적용함

### revert vs reset
- 둘다 커밋을 취소할때 사용
- revert는 기존 변경사항을 다시 되돌리는 커밋을 새로 생성함
  - git history를 깔끔하게 유지하고싶어하는 사람은 싫어할 수 있으나 다른 협업자들간에 문제가 생길소지가 없음
  - git revert <commit_hash>: option으로 들어온 커밋을 revert 함
- reset은 이전 커밋으로 돌아가는 개념(HEAD를 옮긴다 라고 표현)
  - git reset <option> <commit_hash>: option으로 들어온 커밋으로 돌아감
  - option으로는 --soft, --hard, --mixed 가있음(option은 생략 가능하며 이때는 default soft)
  - https://git-scm.com/book/ko/v2/Git-%EB%8F%84%EA%B5%AC-Reset-%EB%AA%85%ED%99%95%ED%9E%88-%EC%95%8C%EA%B3%A0-%EA%B0%80%EA%B8%B0
  - 위 글 보고 옵션이 이해가 안가면...그냥 한번 해보세요. 망칠까봐 정 불안하면 토요일에 해보고 망친것같다 싶으면 일요일 스터디날에 저한테 말씀하심 될듯
  - 이미 서버(remote)에 push 가 된 커밋들을 reset 하게되면 서버와 로컬간의 커밋히스토리가 일치하지않는 문제가 발생. 이때는 강제로 push 하기위해 --force 옵션 사용
  - git push <remote_name> <branch_name> --force

### 가변 vs 불변
- 가변은 객체 내부의 상태를 바꿀 수 있음
  - 흔히 말하는 setter 가 내부 상태를 바꾸는 역할을 하는 메서드
```
static class Person {                 
	private String name;              
                                      
	public Person(String name) {      
		this.name = name;             
	}                                 
                                      
	public String getName() {         
		return name;                  
	}                                 
                                      
	public void setName(String name) {
		this.name = name;             
	}                                 
}                                     
```
- 불변은 한번 생성된 객체의 상태를 바꿀 수 없음
  - 보통 생성자를 통해서 처음에만 주입받고 setter를 제공하지않음
```
static class Person {                     
	private String name;                  
                                          
	public Person(String name) {          
		this.name = name;                 
	}                                     
                                          
	public String getName() {             
		return name;                      
	}                                     
                                          
	public Person withName(String name) { 
		return new Person(name);          
	}                                     
}                                         
```
