# ๐LecturePedia

> SpringBoot์ Spring Data JPA๋ฅผ ์ฌ์ฉํ์ฌ ์น ๊ฒ์ํ ๊ตฌํํ๊ธฐ

![](src/main/resources/static/assets/documents/main.png)

## <a name="toc"></a>ToC

1. [๊ธฐ์  ์คํ](#1)
3. [ํต์ฌ ๊ธฐ๋ฅ](#2)
4. [ํธ๋ฌ๋ธ ์ํ](#3)
5. [ํ๋ก์ ํธ๋ฅผ ํตํด ๋ฐฐ์ด  ๊ฒ](#4)

<br>

## [๐](#toc)<a name="1">1. ๊ธฐ์  ์คํ</a>

<table>
  <tr>
    <th style="width: 20%;">Spring Boot</th>
    <td>๋ณธ ํ๋ก์ ํธ๋ Spring Boot 2.4.5๋ก ๊ฐ๋ฐํ์์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">Spring Data JPA</th>
    <td>JPA์์ ์๋์์ฑํด์ฃผ๋ ๋ฉ์๋๋ฅผ ์ฌ์ฉํ์ฌ ์ฟผ๋ฆฌ๋ฅผ ์ง์  ์์ฑํ๋๋์  OOP์ ์ง์คํ๋ฉฐ ๊ฐ๋ฐํ  ์ ์์์ต๋๋ค. </td>
  </tr>
  <tr>
    <th style="width: 20%;">Spring Security</th>
    <td>ํ์๊ฐ์๊ณผ ๋ก๊ทธ์ธ ๊ณผ์ ์์ ์ฌ์ฉ์์ ๋น๋ฐ๋ฒํธ๋ฅผ ํ๋ฌธ๋์  Bcrypt ํด์ํจ์๋ก ์ธ์ฝ๋ฉํ ๊ฐ์ ์ ์ฅํ์์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">Ajax</th>
    <td>ํ์๊ฐ์ ๊ณผ์ ์์ ์ด๋ฉ์ผ ์ค๋ณต๊ฒ์ฌ๋ฅผ, ๋ก๊ทธ์ธ ๊ณผ์ ์์ ์ด๋ฉ์ผ/๋น๋ฐ๋ฒํธ ๊ฒ์ฆ์ Ajax๋ก ๊ฒ์ฆํ์์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">Mustache</th>
    <td>ํ๋ฉด์์ ๋ก์ง์ ์ฌ์ฉํ์ง ์๋ ํํ๋ฆฟ ์์ง, Mustache๋ฅผ ์ฌ์ฉํ์ฌ ํ๋ฉด์ ๊ตฌํํ์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">Lombok</th>
    <td>VO ํ๋๋ฅผ ์ถ๊ฐํ๊ฑฐ๋ ์ญ์ ํ ๋ Getter/Setter๋ฅผ ์์ํ๋ ๋์  Lombok ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ฅผ ์ฌ์ฉํ์ฌ ๋ถํ์ํ ์ฝ๋ ์์ฑ์ ์ต์ํํ์์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">H2 Databse</th>
    <td>๋ก์ปฌ ํ๊ฒฝ์์ ๊ฐ๋ฐํ  ๋ ํธ๋ฆฌํ ๊ฐ๋ฐ์ ์ํด H2 ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ฅผ ์ฌ์ฉํ์ฌ ๊ฐ๋ฐํ์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">MySQL</th>
    <td>์์์ ์ธ ๋ฐ์ดํฐ ์ฌ์ฉ์ ์ํด MySQL์ RDBMS๋ก ์ฌ์ฉํ์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">Docker</th>
    <td>MySQL์ ์ปจํ์ด๋ ๊ธฐ๋ฐ์ผ๋ก ์ฌ์ฉํ๊ธฐ ์ํด Docker๋ฅผ ์ฌ์ฉํ์ต๋๋ค.</td>
  </tr>
  <tr>
    <th style="width: 20%;">JUnit5</th>
    <td>์๋น์ค ๋ก์ง ๊ฒ์ฆ์ ์ํด ํ์คํธ ํ๋ ์์ํฌ๋ฅผ ์ฌ์ฉํ์ต๋๋ค.</td>
  </tr>
</table>


<br>

## [๐](#toc)<a name="2">2. ํต์ฌ ๊ธฐ๋ฅ</a>

- [๋น๋ฐ๋ฒํธ ์ํธํ](#2-1)
- [admin ๊ถํ ๋ถ์ฌ ๋ฐ ์ฌ์ฉ์ ๊ด๋ฆฌ](#2-2)

- [์กฐํ์ ๊ธฐ๋ฅ ์ถ๊ฐ (์์ฑ์ ๋ณธ์ธ ๋๋ Admin์ ์กฐํ์ ์นด์ดํโ๏ธ)](#2-3)
- [๋ฉ์ธ ํ์ด์ง์์ ์กฐํ์ ๋์ 4๊ฐ์ ๊ฒ์๊ธ ๋ธ์ถ](#2-4)
- [์ต๊ทผ์์ฑ์์ผ๋ก ๊ฒ์๊ธ ์ ๋ ฌ ๋ฐ ํ ํ์ด์ง์ ๊ฒ์๊ธ 5๊ฐ์ฉ ๋ธ์ถ๋๋๋ก ํ์ด์ง ๊ตฌํ](#2-5)

### [๐](#2) <a name="2-1">2-1. ๋น๋ฐ๋ฒํธ ์ํธํ</a>

![](src/main/resources/static/assets/documents/feature2-1.gif)

Spring Security์ ๋ด์ฅ๋ Password ์ธํฐํ์ด์ค์ `encode()`๋ฅผ ์ฌ์ฉํ์ฌ ๋น๋ฐ๋ฒํธ๋ฅผ ์ํธํํ์์ต๋๋ค. ์ด๋ ๊ฒ ์ํธํํ ๋น๋ฐ๋ฒํธ๋ ์๋ฒ์์ ํ๋ฌธ ๋น๋ฐ๋ฒํธ๋ฅผ ์ ์ ์์ผ๋ฏ๋ก `equals()` ๋์  Password ์ธํฐํ์ด์ค์ ๋ด์ฅ๋ `matches()` ๋ฅผ ์ฌ์ฉํ์ฌ ์ฌ์ฉ์๊ฐ ์๋ ฅํ ํ๋ฌธ ๋น๋ฐ๋ฒํธ์ ์๋ฒ์ ์ ์ฅ๋ ์ธ์ฝ๋ฉ๋ ๋น๋ฐ๋ฒํธ๋ฅผ ๋น๊ตํ์ฌ ๋ฐํ๋ boolean ๊ฐ์ ํตํด ๋ก๊ทธ์ธ์ ๊ฒ์ฆํ์์ต๋๋ค. 

**userLogin.html**

~~~html
<button class="btn btn-success pull-right"
      style="margin-top: 1.5em;"
      onclick="validationLogin();"
      type="button">๋ก๊ทธ์ธ</button>
~~~

Form์์ ๋ฒํผ์ ์์ฑํด์ ๋ฒํผ์ ํด๋ฆญํ๋ฉด, ์๋ฐ ์คํฌ๋ฆฝํธ๋ก ์์ฑ๋ ๋ก๊ทธ์ธ ๊ฒ์ฆ ํจ์(`function validationLogin()`)๊ฐ ์คํ๋๋๋ก ํ์์ต๋๋ค. ์ผ๋ฐ์ ์ผ๋ก Form ์์ ๋ฒํผ์ ์์ฑํ๋ฉด submit์ด ๋๋ฏ๋ก `type="button"` ์์ฑ์ ์ถ๊ฐํ์ฌ ์๋์ผ๋ก submit๋์ง ์๊ณ  `validationLogin()` ์ ์ํด submit๋๋๋ก ํ์์ต๋๋ค.

~~~javascript
function validationLogin() {
   let email = document.getElementById('email').value;
   let password = document.getElementById('password').value;
   let loginForm = document.loginForm;

   let isOkEmail = validationEmail(email);
   if(isOkEmail) {
   let isOkPassword = validationPassword(email, password);
      if(isOkPassword) {
         alert("Welcome back!");
         loginForm.submit();
      } else { alert("๋น๋ฐ๋ฒํธ๋ฅผ ์๋ชป ์๋ ฅํ์์ต๋๋ค."); }
   } else { alert("์ด๋ฉ์ผ์ ์๋ชป ์๋ ฅํ์์ต๋๋ค."); }
}
~~~

๋ก๊ทธ์ธ ๊ฒ์ฆ ํจ์๊ฐ ์คํ๋๋ฉด ์ฌ์ฉ์๊ฐ ์๋ ฅํ ์ด๋ฉ์ผ๊ณผ ๋น๋ฐ๋ฒํธ๋ฅผ ํ๋ฉด์์ ๊ฐ์ ธ์์ ๊ฐ๊ฐ์ ๋ค์ ๊ฒ์ฆํ๋ Ajax๋ฅผ ์คํํ์ฌ ๋ฐํ๋๋ ๊ฒฐ๊ณผ(`boolean`)์ ๋ฐ๋ผ ์ด๋ค ์์ญ์์ ์๋ชป๋์๋์ง๋ฅผ ํ๋ฉด์์ ์๋ ค์ฃผ๊ณ , ๋ชจ๋  ๊ฒ์ฆ์ ํต๊ณผํ๋ฉด Form์ด submit๋๋๋ก ํ์์ต๋๋ค.

์ฌ์ฉ์์ ์ด๋ฉ์ผ์ ํตํด Repository๋ฅผ ์กฐํํ์ฌ ์ธ์ฝ๋ฉ๋ ๋น๋ฐ๋ฒํธ๋ฅผ ์ ๊ทผํ  ์ ์์ผ๋ฏ๋ก ์ด๋ฉ์ผ ๊ฒ์ฆ์ด ํต๊ณผํ์ง ๋ชปํ๋ฉด ๋น๋ฐ๋ฒํธ ๊ฒ์ฆ ํจ์๊ฐ error๋ฅผ ๋ฐํํ๊ฒ ๋ฉ๋๋ค. ๋ฐ๋ผ์ ์ด๋ฉ์ผ ๊ฒ์ฆ์์ true๋ฅผ ๋ฐํ๋ฐ์ ๊ฒฝ์ฐ์๋ง ๋น๋ฐ๋ฒํธ ๊ฒ์ฆ ํจ์๋ฅผ ์คํํ๋๋ก Ajax ํจ์๋ฅผ ๋๊ธฐ์ (`async: false`)์ผ๋ก ์ํํ๋๋ก ํ์์ต๋๋ค.

~~~javascript
function validationPassword(email, password) {
   let result = false;
   $.ajax({
      type: 'POST',
      url: '/user/passwordChk',
      async: false,
      dataType: 'json',
      data: {
         'email': email,
         'password': password
      },
      success: function(data) {
         if(data) {
            result = true;
         }
      },
      error: function(error){
         alert("๋น๋ฐ๋ฒํธ ๊ฒ์ฆ ์ค๋ฅ !!");
         alert(error);
      }
   });
   return result;
}
~~~

API ์์ฒญ์ ๊ฒฐ๊ณผ๋ฅผ boolean ํ์์ผ๋ก ๋ฐ์์ ๋ฐํ๊ฐ์ ๋ฐ๋ผ ๋ค์ ์คํฌ๋ฆฝํธ ํจ์๋ฅผ ์คํํ๋๋ก ํ์์ต๋๋ค. 

**UserController.java**

~~~java
@RequestMapping(value = "/user/passwordChk", method = RequestMethod.POST)
public @ResponseBody boolean validationPasswordByLogin(@RequestParam String email, @RequestParam String password) {
   return userService.validationLoginByPassword(email, password);
}
~~~

`Model`์ ๋ฐํํ๋ ์ปจํธ๋กค๋ฌ๊ฐ ์๋ `boolean` ํ์์ entity๋ฅผ ๋ฐํํ๋ ์ปจํธ๋กค๋ฌ์ด๋ฏ๋ก `@ResponseBody` ์ด๋ธํ์ด์์ ์ฌ์ฉํ์ต๋๋ค.

์ค์  ๋น๋ฐ๋ฒํธ๋ฅผ ๋น๊ตํ๋ ๋ฉ์๋๋ ์๋์ ๊ฐ์ต๋๋ค.

**UserServiceImpl.java**

~~~java
@Override
public boolean validationLoginByPassword(String email, String password) {
   User targetUser = userRepository.findByEmail(email);
   return passwordEncoder.matches(password, targetUser.getPassword());
}
~~~

์ค์ ๋ก `passwordEncoder.matches()`๊ฐ ์์๋ํ๋์ง ํ์คํธ๋ฅผ ์คํํ์ต๋๋ค.

![](src/main/resources/static/assets/documents/password-encoder-test.png)

<br>

### [๐](#2) <a name="2-2">2-2. admin ๊ถํ ๋ถ์ฌ ๋ฐ ์ฌ์ฉ์ ๊ด๋ฆฌ</a>

![](src/main/resources/static/assets/documents/feature2-2.gif)

Enum์ผ๋ก ์์ฑ๋  `Role`์ด `Role.Admin`์ด๋ฉด ๋ฉ์ธํ์ด์ง์์ ์ฌ์ฉ์ ๋ชฉ๋ก ํ์ด์ง์ ์ ๊ทผํ  ์ ์์ผ๋ฉฐ, ์ฌ๊ธฐ์ ์ฌ์ฉ์๋ฅผ ์ญ์ ํ  ์ ์์ต๋๋ค.

๋ํ Admin์ ๋ชจ๋  ๊ฒ์๊ธ์ ๋ํด ์ญ์  ๊ถํ์ ๊ฐ๊ณ ์์ต๋๋ค.  

**UserController.java**

~~~java
@GetMapping("/user/list")
public String userList(HttpSession session, Model model) {
   if(HttpSessionUtils.hasRoleLoginUser(session, Role.ADMIN)) {
      model.addAttribute("users",userService.getAllUsers());
      return "user/userList";
   }
   return "redirect:/";
}
~~~

**HttpSessionUtils.java**

~~~java
public static boolean isLoginUser(HttpSession session) {
   if(getUserFromSession(session)==null) {
      return false;
   }
   return true;
}

public static boolean hasRoleLoginUser(HttpSession session, Role role) {
   if(isLoginUser(session)) {
      Role roleOfCurrentUser = getUserFromSession(session).getRole();
      return roleOfCurrentUser.equals(role);
   }
   return false;
}
~~~

์ปจํธ๋กค๋ฌ๋ฅผ ํตํด ์ฌ์ฉ์ ๋ชฉ๋ก ์กฐํ API ์์ฒญ์ด ๋ค์ด์ค๋ฉด, ์ธ์๊ด๋ จ ๋ฉ์๋๋ฅผ ๋ถ๋ฆฌํ ์ฑ๊ธํค ๊ฐ์ฒด `HttpSessionUtils`์ ๋ฉ์๋๋ฅผ ์ด์ฉํ์ฌ ํ์ฌ ์ธ์์ ์ฌ์ฉ์๊ฐ `Role.ADMIN`์ ๊ถํ์ด ์๋์ง๋ฅผ ๊ฒ์ฆํฉ๋๋ค. ๊ถํ์ด ์๋ค๋ฉด ์ฌ์ฉ์ ๋ชฉ๋ก ํ์ด์ง๋ฅผ ๋ฐํํด์ฃผ๊ณ , ๊ทธ๋ ์ง ์์ผ๋ฉด ๋ค์ ๋ฉ์ธํ์ด์ง๋ก ๋ฐํํฉ๋๋ค.

<br>

### [๐](#2) <a name="2-3">2-3. ์กฐํ์ ๊ธฐ๋ฅ ์ถ๊ฐ</a>

![](src/main/resources/static/assets/documents/feature2-3.gif)

๊ฒ์๊ธ์ ์ ๊ทผํ๋ฉด ์กฐํ์๊ฐ ์ฌ๋ผ๊ฐ๋๋ค. ๊ทธ๋ฌ๋ ๊ฒ์๊ธ ์์ฑ์ ๋ณธ์ธ ๋๋ Admin์ด๋ผ๋ฉด ๊ฒ์๊ธ ์กฐํ์๋ ์ฌ๋ผ๊ฐ์ง ์๋๋ก ๊ฒ์ฆ ๋ก์ง์ ๊ตฌํํ์์ต๋๋ค.

~~~java
@GetMapping("/lecture/{lectureId}")
public String getLecture(@PathVariable Long lectureId, Model model, HttpSession session) {
   if(!HttpSessionUtils.isLoginUser(session)) {
      return "redirect:/login";
   }
   if(userService.hasAuthority(lectureId, session)) {
      model.addAttribute("authority", true);
   } else {
      lectureService.increaseViewCount(lectureId);
   }
   Lecture targetLecture = lectureService.getLecture(lectureId);
   model.addAttribute("lecture",targetLecture);
   return "lecture/detailLecture";
}
~~~

๊ฒ์๊ธ์ ์ ๊ทผํ๋ API ์์ฒญ์ด ์ปจํธ๋กค๋ฌ๋ก ๋ค์ด์ค๋ฉด, ์ฐ์  ๋ก๊ทธ์ธํ ์ฌ์ฉ์์ธ์ง๋ถํฐ ๊ฒ์ฆํ๊ณ , ๋ก๊ทธ์ธํ ์ฌ์ฉ์๋ผ๋ฉด ๊ถํ์ ๊ฒ์ฆํ์์ต๋๋ค. 

๋ง์ฝ ๊ฒ์๊ธ ์์ฑ์๊ฑฐ๋ Admin์ด๋ฉด, ๊ฒ์๊ธ์ ์์  ๋๋ ์ญ์  ๋ฒํผ์ด ๋ณด์ฌ์ง๋๋ก `Model`์ boolean๊ฐ์ ๋ด์์ต๋๋ค.

~~~html
{{#authority}}
<a href="/lecture/update/{{lecture.id}}">
  <button class="btn btn-success pull-right" style="float: left; margin-top: 1em; margin-left: 1em">์์ ํ๊ธฐ</button>
</a>
<button class="btn btn-danger pull-right"
        style="margin-top: 1em; margin-left: 1em"
        onclick="deleteLecture();">์ญ์ ํ๊ธฐ</button>
{{/authority}}
~~~

์ปจํธ๋กค๋ฌ๋ฅผ ํตํด ๋์ด์จ Model ๊ฐ์ฒด์ค `"authority"` ์ด๋ฆ์ ๊ฐ์ฒด๊ฐ ์๋ค๋ฉด, ์์ /์ญ์ ํ๊ธฐ ๋ฒํผ์ ์ถ๋ ฅํฉ๋๋ค.

๊ฒ์๊ธ ์์ฑ์ ๋๋ Admin์ด ์๋๋ผ๋ฉด ์กฐํ์๋ฅผ ์ฆ๊ฐํ๋ ์๋น์ค ๋ก์ง์ ํธ์ถํ์ต๋๋ค.

~~~java
@Override
public void increaseViewCount(Long id) {
   Lecture targetLecture = getLecture(id);
   targetLecture.setViews(targetLecture.getViews()+1);
   lectureRepository.save(targetLecture);
}
~~~

<br>

### [๐](#2) <a name="2-4"> 2-4. ๋ฉ์ธ ํ์ด์ง์์ ์กฐํ์ ๋์ 4๊ฐ์ ๊ฒ์๊ธ ๋ธ์ถ

![๋ฉ์ธํ์ด์ง ์กฐํ์ ๋์ 4๊ฐ ๊ฒ์๊ธ ๋ธ์ถ](src/main/resources/static/assets/documents/feature2-4.gif)

์กฐํ์ ๋์ 4๊ฐ์ ๊ฒ์๊ธ์ ๋ฉ์ธ ํ์ด์ง์ ๋ธ์ถ์ํค๋ ๋ก์ง์ ๊ตฌํํ์์ต๋๋ค. ์ด๋ฅผ ์ํด Repository์์ ์กฐํ์ ๊ธฐ์ค์ผ๋ก ์์ 4๊ฐ์ ๊ฒ์๊ธ์ ๋ถ๋ฌ์ค๋ ๋ฉ์๋๋ฅผ ์ ์ธํ์ต๋๋ค.

~~~java
@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
   List<Lecture> findTop4ByOrderByViewsDesc();
~~~

JpaRepository๋ฅผ ์์๋ฐ๋ `LectureRepository`์์ `findTop4ByOrderByViewsDesc()`๋ฅผ ์ ์ธํ๋ฉด Hibernate์์ ์๋์ผ๋ก ์ฟผ๋ฆฌ๋ฅผ ์์ฑํ๋๋ฐ ์ด ๋ ์์ฑ๋๋ ์ฟผ๋ฆฌ๋ ์๋์ ์ฟผ๋ฆฌ์ ๊ฐ์ต๋๋ค.

~~~sql
SELECT * FROM Lecture Order BY views DESC LIMIT 4;
~~~

Hibernate์์ ์์ฑํ๋ ์ฟผ๋ฆฌ๋ฅผ ์ฝ์์ ์ถ๋ ฅ๋๋๋ก application.properties์ ์ค์ ์ ์ถ๊ฐํด์ ํ์ธํ๊ฒฐ๊ณผ ์๋์ ์ฟผ๋ฆฌ๋ฅผ ์์ฑํ๋๊ฑธ ํ์ธํ์์ต๋๋ค.

~~~properties
spring.jpa.show-sql=true
~~~

![](src/main/resources/static/assets/documents/query-hibernate-created.png)

 <br>

### [๐](#2) <a name="2-5"> 2-5. ์ต๊ทผ์์ฑ์์ผ๋ก ๊ฒ์๊ธ ์ ๋ ฌ ๋ฐ ํ ํ์ด์ง์ ๊ฒ์๊ธ 5๊ฐ์ฉ ๋ธ์ถ๋๋๋ก ํ์ด์ง ๊ตฌํ

![แแฆแแตแแตแผ](src/main/resources/static/assets/documents/feature2-5.gif)

ํ ํ์ด์ง์ ๊ฐ์ 5๊ฐ๋ง ๋ณด์ด๋๋ก ํ์ด์ง์ ๊ตฌํํ์์ต๋๋ค.

Jpa์์๋ `Pageable`์ ์ด์ฉํด์ ๊ฐ๋จํ๊ฒ ํ์ด์ง์ ๊ตฌํํ  ์ ์์์ต๋๋ค. 

**LectureController.java**

~~~java
@GetMapping("/lecture/list")
public String retrievePosts(final @PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
   if(lectureService.isEmptyList()) {
      return "redirect:/lecture/register";
   }

   Page<Lecture> lecturesForPage = lectureService.getLecturesByPagination(pageable);
   List<Lecture> lectures = lecturesForPage.getContent();
   model.addAttribute("lectures", lectures);

   long totalCount = lectureService.getLecturesTotalCount();
   model.addAttribute("totalCount",totalCount);
   return "lecture/listLecture";
}
~~~

`@PageableDefault` ์ด๋ธํ์ด์์ ์ฌ์ฉํด์ ํ์ด์ง์ ๋ํดํธ๋ฅผ ์ค์ ํ์์ต๋๋ค. `size`๋ ํ ํ์ด์ง์ ๋ณด์ฌ์ค ๊ฐ์ฒด์๋ฅผ, `page`๋ API ์์ฒญ์ด ๋ค์ด์์๋ ๋ณด์ฌ์ง ํ์ด์ง ๋ฒํธ๋ฅผ ์๋ฏธํฉ๋๋ค. 

**LectureServiceImpl.java**

~~~java
@Override
public Page<Lecture> getLecturesByPagination(Pageable pageable) {
   return lectureRepository.findAllByOrderByFirstCreatedDateDesc(pageable);
}
~~~

Repository์์ `findAllByOrderByFirstCreatedDateDesc()` ๋ฉ์๋๋ฅผ ์์ฑํด์ ์๋น์ค์์ ํธ์ถํ๋ ์ฝ๋๋ฅผ ์์ฑํ์์ต๋๋ค.

**LectureRepository.java**

~~~java
@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
   Page<Lecture> findAllByOrderByFirstCreatedDateDesc(Pageable pageable);
~~~

์์ Jpa ๋ฉ์๋๋ฅผ ํตํด Hibernate๊ฐ ์์ฑํ๋ ์ฟผ๋ฆฌ๋ ์๋์ ๊ฐ์ต๋๋ค.

~~~sql
SELECT * FROM Lecture Order By firstCreatedDate DESC LIMIT 5 OFFSET 40
~~~

![](src/main/resources/static/assets/documents/query-hibernate-created2.png)

<br>

## [๐](#toc)<a name="3">3. ํธ๋ฌ๋ธ ์ํ</a>

### 3-1. Ajax ๋๊ธฐ ํธ์ถ

[๋ก๊ทธ์ธ ๊ฒ์ฆ ์ฝ๋](https://github.com/youngjinmo/LecturePedia/blob/mysql/src/main/resources/templates/user/userLogin.html)

๋ก๊ทธ์ธ ๊ฒ์ฆ์ ํ๋ ๊ณผ์ ์์ ์๋ฐ ์คํฌ๋ฆฝํธ ํจ์๋ฅผ 3๊ฐ๋ฅผ ์ฌ์ฉํ์ต๋๋ค. ํ๋๋ ์ด๋ฉ์ผ ๊ฒ์ฆ, ํ๋๋ ๋น๋ฐ๋ฒํธ ๊ฒ์ฆ ๊ทธ๋ฆฌ๊ณ  ํ๋๋ ์์  ๋ ๊ฐ์ ํจ์๋ฅผ ํธ์ถํ๋ ํจ์์์ต๋๋ค. ์ด๋ฉ์ผ ํจ์๊น์ง๋ ๋ฌธ์ ๊ฐ ์์์ผ๋ ๋น๋ฐ๋ฒํธ ๊ฒ์ฆ ํจ์๋ฅผ ํธ์ถํ๋ ๊ณผ์ ์์ ์๋์ ๋ค๋ฅด๊ฒ API ๊ฒฐ๊ณผ๋ฅผ ์ ๋๋ก ๊ฐ์ ธ์ค์ง ๋ชปํ๋ ํ์์ด ๋ฐ์ํ์ต๋๋ค.

๋ฌธ์ ์ ์์ธ์ Ajax๊ฐ ๊ธฐ๋ณธ์ ์ผ๋ก ๋น๋๊ธฐ๋ก ์๋ํ๋ค๋ ์ ์ ์ธ์งํ์ง ์๊ณ  ์คํฌ๋ฆฝํธ ํจ์๋ฅผ ์์ฐจ์ ์ผ๋ก ํธ์ถํ ์  ์๋ชป์ด์์ต๋๋ค. 

๋ก๊ทธ์ธ ๊ณผ์ ์์์ ๊ฒ์ฆ์ ์๋์ ์์๋๋ก ์งํ๋์ด์ผ ํ์ต๋๋ค.

1. ์ด๋ฉ์ผ ๊ฒ์ฆ
2. ์ด๋ฉ์ผ ๊ฒ์ฆ์ด ํต๊ณผ๋์๋ค๋ฉด, ํด๋น ์ด๋ฉ์ผ๊ณผ ๋น๋ฐ๋ฒํธ๋ฅผ ํ๋ผ๋ฏธํฐ๋ก APIํธ์ถํ์ฌ ๋น๋ฐ๋ฒํธ ๊ฒ์ฆ
3. ๋น๋ฐ๋ฒํธ ๊ฒ์ฆ๊น์ง ํต๊ณผํ๋ค๋ฉด, submit ํธ์ถ 

๋ฐ๋ผ์ ๋ก๊ทธ์ธ ๊ฒ์์ ๋ชจ๋  ์คํฌ๋ฆฝํธ ํจ์๊ฐ ์์ฐจ์ ์ผ๋ก ํธ์ถ๋ ์ ์๋๋ก `async=false`๋ก ์ง์ ํ์๋๋ ์๋ํ๋๋ก ๋ก๊ทธ์ธ ๊ฒ์ฆ์ ํ  ์ ์์์ต๋๋ค.

<br>

### 3-2. RDBMS ๋ณ๊ฒฝ(H2->MySQL)

์ธ๋ฉ๋ชจ๋ฆฌ ๊ธฐ๋ฐ์ h2๋ฐ์ดํฐ ๋ฒ ์ด์ค์์ ์์์ ์ผ๋ก(persistence) ์ฌ์ฉํ  ์ ์๋ MySQL์ ์ฌ์ฉํ๊ธฐ ์ํด RDBMS๋ฅผ ๋ณ๊ฒฝ์ ์๋ํ์ต๋๋ค. 

๋จผ์  ๋์ปค์์ MySQL ์ด๋ฏธ์ง๋ฅผ ๋ด๋ ค๋ฐ์ ์ปจํ์ด๋๋ฅผ ์์ฑํ์ต๋๋ค.

~~~bash
docker search mysql
docker pull mysql

docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password mysql
~~~

๊ทธ๋ฆฌ๊ณ  ์ปจํ์ด๋์ ์ ์ํ์ฌ, MySQL๋ฅผ ์คํํ์ต๋๋ค.

~~~bash
docker exec -it mysql bash
root@528e18f1f85b:/# mysql -uroot -p
~~~

์ดํ๋ถํฐ ์์ฐจ์ ์ผ๋ก ์ฌ์ฉ์ ๊ณ์ ์ ์์ฑํ๊ณ , ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ํ์ด๋ธ์ ์์ฑํ์ต๋๋ค.

~~~sql
CREATE USER devandy@'%' identified by 'password';
CREATE DATABASE lecturepedia;
~~~

~~~sql
create table lecture (
   id bigint primary key auto_increment,
   first_created_date timestamp,
   last_modified_date timestamp,
   author_id bigint,
   author_name varchar(255),
   creator varchar(255) not null,
   description varchar(255) not null,
   lecture_url varchar(255) not null,
   title varchar(255) not null,
   views bigint
);

create table user (
   id bigint primary key auto_increment,
   first_created_date timestamp,
   last_modified_date timestamp,
   email varchar(255) not null,
   password varchar(255) not null,
   role varchar(255) not null,
   user_name varchar(255) not null
);
~~~

์ด์  MySQL๊ณผ ๊ด๋ จํ Gradle ์์กด์ฑ์ ์ฃผ์ํ์ต๋๋ค.

~~~groovy
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.25'
implementation group: 'org.springframework.boot', name: 'spring-boot-starter-data-jdbc', version: '2.5.0'
~~~

 ๊ทธ๋ฆฌ๊ณ  application.properties๋ฅผ ์์ ํ์ต๋๋ค. H2 ๊ด๋ จ ์์ฑ์ ๋ชจ๋ ์ฃผ์์ฒ๋ฆฌํ๊ณ , MySQL ๊ด๋ จ ์์ฑ์ ์ถ๊ฐํด์ฃผ์์ต๋๋ค.

~~~properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/lecturepedia
spring.datasource.username=devandy
spring.datasource.password=password
~~~

Docker๋ก MySQL ์ปจํ์ด๋๋ฅผ ์คํํ๊ณ , Debug๋ก ์ ํ๋ฆฌ์ผ์ด์์ ์คํํ๋ ๋ค์๊ณผ ๊ฐ์ ์๋ฌ๋ฅผ ๋ง์ฃผํ์ต๋๋ค.

![](src/main/resources/static/assets/documents/db-error.png)

`SQLException`์ด ๋ฐ์ํ๊ณ , ์๋ฌ ๋ก๊ทธ๋ฅผ ๋ณด๋ `Access denied for user 'devandy@172.17.0.1'` ์ด ๋ก๊ทธ์ ์ฐํ๊ฑธ๋ก ๋ณด์ devandy๋ผ๋ DB ์ฌ์ฉ์ ๊ณ์ ์ ์ ๊ทผํ ๋ ๋ฌธ์ ๊ฐ ๋ฐ์ํ์์ ์ ์ ์์์ต๋๋ค. ์คํ์ค๋ฒํ๋ก์ฐ๋ฅผ ํตํด์ ์ด๋ฐ ๊ฒฝ์ฐ, DB ์ฌ์ฉ์๊ณ์ ์ ๋ํ privileges๋ก์ธํ ๋ฌธ์ ์ผ ์ ์๋ค๊ณ  ํ์ฌ MySQL ์ปจํ์ด๋์ ์ ์ํ์์ต๋๋ค.

Privileges๋ฅผ ์์ ํ๊ธฐ ์ํด ์๋ํ์์ผ๋ ํด๋น ์ฌ์ฉ์๊ฐ ํ์ด๋ธ์ ์กด์ฌํ์ง ์์์ ๊ถํ์ ๋ถ์ฌํ  ์ ์์์ต๋๋ค. ๊ทธ๋์ ์ฌ์ฉ์๋ฅผ ๋ค์ ์์ฑํ๋ ค๊ณ  ํ์์ผ๋ ์ด๋ฒ์ ์๋์ ๊ฐ์ ์๋ฌ ๋ก๊ทธ๊ฐ ์ถ๋ ฅ๋์์ต๋๋ค. 

~~~
ERROR 1396 (HY000): Operation CREATE USER failed for 'devandy'@'localhost'
~~~

์ฌ์ฉ์ ๋ชฉ๋ก์์๋ ๋ณด์ด์ง ์์์ผ๋ ์ด๋ฐ์ ๋ฐ ํ์คํธํ๋ ๊ณผ์ ์์ DB์ ํ ๋ฒ ์์ฑ๋์ ์ด ์๋ `devandy` ๋ผ๋ ๊ณ์ ์ด ์์ ํ ์ญ์ ๋๊ฒ ๊ฐ์ง ์์์ต๋๋ค. ๊ทธ๋์ ์๋์ ๋ช๋ น์ด๋ก ์์ ํ ์ญ์ ์ดํ์ ๋ค์ ์์ฑํ์ต๋๋ค.

~~~sql
DROP USER 'devandy'@'localhost'
flush privileges;
CREATE USER 'devandy'@'localhost' IDENTIFIED BY 'password';
~~~

์ฟผ๋ฆฌ๊ฐ OK ๋์์์ ํ์ธํ๊ณ , ์ด์  ๊ถํ์ ๋ถ์ฌํ์์ต๋๋ค.

~~~sql
GRANT ALL privileges on lecturepedia.* to devandy@'localhost';
~~~

์ธ๋ถ์์ ์ ๊ทผํ  ์ ์๋๋ก '%'๋ ๋ชจ๋  ๊ถํ์ ๋ถ์ฌํ์ต๋๋ค.

~~~sql
CREATE USER devandy@'%' identified by 'password';
GRANT ALL privileges on lecturepedia.* to devandy@'%';
~~~

๋ค์ Debug๋ก ์คํํ๋ ์ด๋ฒ์ SEQUENCE ์๋ฌ๊ฐ ๋ฐ์ํ์ต๋๋ค. ๊ฒ์์ ํด๋ณด๋ JPA ๊ด๋ จ ์๋ฌ์๋๋ฐ, application.properties์์ JPAํ๋ซํผ์ MySQL๋ก ํ์ง์์์ ๋ฐ์ํ ๋ฌธ์ ์์ต๋๋ค.

![](src/main/resources/static/assets/documents/db-error2.png)

~~~properties
# spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
~~~

์ด๋ ๊ฒ๊น์ง ์์ ํ๊ณ  ๋ค์ ์ ํ๋ฆฌ์ผ์ด์์ ์คํํ๋ฉด ์ ๋๋ก ์คํ๋์์ต๋๋ค.

<br>

## [๐](#toc)<a name="4">4. ํ๋ก์ ํธ๋ฅผ ํตํด ๋ฐฐ์ด ๊ฒ</a>

### 4-1. ์คํ๋ง ํ๋ ์์ํฌ์์์ DIP

OOP๋ฅผ ์ํด์ ์์กด์ฑ์ ์ธ๋ถ์์ ์ฃผ์ํ๋ ํํ๋ก ์๋ฐ ํ๋ก๊ทธ๋๋ฐ์ ํ๋๋ฐ, ์คํ๋ง๋ถํธ ํ๋ก์ ํธ์์  `@Autowired` ์ด๋ธํ์ด์์ผ๋ก DI๋ฅผ ์ฝ๊ฒ ๊ตฌํํ  ์ ์์์ต๋๋ค. ์์กด์ฑ์ด ์ถ๊ฐ๋ ๋๋ง๋ค ๊ฐ๋ฐ์๊ฐ ์ง์  ์์ฑ์์ ํ๋ผ๋ฏธํฐ๋ฅผ ์ถ๊ฐํ  ํ์์์ด, ์ด๋ธํ์ด์์ ์ฌ์ฉํ๋ฉด ์ฝ๊ฒ ์์กด์ฑ์ ์ธ๋ถ์์ ์ฃผ์๋ฐ๋๋ก ์ค๊ณํ  ์ ์์์ต๋๋ค.

`@Autowired`๋ฅผ ํ  ์ ์๋ ๋์์ ์คํ๋ง ํ๋ ์์ํฌ์์ ๊ด๋ฆฌํ๋ Bean์ผ๋ก ํ์ ๋๋๋ฐ, ์ด ๋๋ ์ญ์ ์ด๋ธํ์ด์(`@Controller`, `@Service`, `@Component`)์ ํตํด ์ฝ๊ฒ Bean์ ๋ฑ๋กํ  ์ ์์์ต๋๋ค. 

MVC ํจํด์ ๋ฌด๊ดํ ๊ฐ์ฒด๋ ๊ฐ๋ฐ์๊ฐ ๋ฐ๋ก ๋น์ผ๋ก ์ฃผ์ํด์ผ ํ๋๋ฐ, ์ด๋ `@Component`๋ ํด๋์ค๋ฅผ, `@Bean`์ ๋ฉ์๋๋ฅผ ๋์์ผ๋ก ์ฌ์ฉํ  ์ ์๋ค๋๊ฒ๋ ํ์ตํ  ์ ์์์ต๋๋ค.

### 4-2. JPA ์ฅ์ 

JPA๋ฅผ ์ฒ์ ์ฌ์ฉํด๋ณด์๋๋ฐ, ๊ฐ๋ฐ์๊ฐ ์ผ์ผํ ์ฟผ๋ฆฌ๋ฅผ ์์ฑํ  ํ์์์ด JpaRepository๋ฅผ ์์๋ฐ๋ Repository ์ธํฐํ์ด์ค๋ฅผ ์์ฑํด์ ๋ฉ์๋ ์ด๋ฆ๋ง์ผ๋ก ์ฟผ๋ฆฌ๊ฐ ์๋์ผ๋ก ์์ฑ๋๋ ์ผ์ด ๋งค์ฐ ํฅ๋ฏธ๋ก์ ์ต๋๋ค. 

์ฒ์์ JPA๊ฐ ์ต์์น ์๋ค๋ณด๋ ์๋์ฒ๋ผ JPQL์ ์ฌ์ฉํ์ฌ ์ง์  ์ฟผ๋ฆฌ๋ฅผ ์์ฑํด์ ์ด์ฉ๋ ํด๋ณด์์ง๋ง, JPA๋ฅผ ์ฌ์ฉํ๋ SQL ์คํ์ ๋ํ ์๋ฌ๋ฅผ ๊ฑฑ์ ํ์ง ์์๋ ๋๋ ๋ ํธ๋ฆฌํ๋ค๋ ๋๋์ ๋ฐ์์ต๋๋ค.

~~~java
@Autowired
private EntityManager entityManeger;
...
@Override
public List<Lecture> getLectureMostView(int count) {
   String query = "SELECT lecture FROM Lecture ORDER BY lecture.views DESC";
   TypedQuery typedQuery = entityManager.createQuery(query, Lecture.class);
   typedQuery.setMaxResults(count);
   return typedQuery.getResultList();
}
~~~

<br>
