# Vizsgaremek
| Vizsgált weboldal címe: | https://www.notebook.hu/ |
| ------ | ------ |
| Git repository: | https://github.com/adammr221/Vizsgaremek_notebook |
| Allure report: | https://adammr221.github.io/Vizsgaremek_notebook/11/ |

## Tesztek:
<em>A teszt script-ek tartalmaznak alapértelmezett tesztadatokat.</em>

### TC1 Regisztráció
- registration/RegistrationTest.java
- testSuccessfulRegistration

Teszt futtatása előtt a teszt script-ben meg kell adni érvényes adatokat.   
Példa:
```sh
registrationPage.setFirstname("Kiss");  
registrationPage.setLastname("Elek");  
registrationPage.setEmailField("elek.teszt.mail@gmail.com");  
registrationPage.setPasswordField("Wsp331.");  
registrationPage.setPasswordField2("Wsp331."); 
``` 
-----

### TC2/TC3 Sikeres/ Sikertelen bejelentkezés
- login/LoginTest.java
- testUnsuccessfulLogin
- testSuccessfulLogin

Teszt futtatása előtt a teszt script-ben meg kell adni érvényes adatokat.  
Példa:
```sh
loginPage.setUsernameField("elek.teszt.mail@gmail.com");  
loginPage.setPasswordField("Wsp331."); 
``` 
-----

### TC4 Sikeres kijelentkezés
- logout/LogoutTest.java
- testSuccessfulLogout

Teszt során először bejelentkezés történik amihez meg kell adni érvényes adatokat,
majd ezt követően a kijelentkezés.  
Példa:
```sh
loginPage.setUsernameField("elek.teszt.mail@gmail.com");  
loginPage.setPasswordField("Wsp331.");  
```
-----

### TC5 Termék törlése a kosárból
- delete_data/DeleteProductFromCartTest.java
- testDeleteProductFromCart

Teszt során a kereső mező kitöltésre kerül egy alapértelmezett értékkel amelyet a teszt scriptben lehet módosítani. Az enter automatikusan lenyomásra kerül majd az első találat bekerül a kosárba. Ha sikeresen bekerül a termék a kosárba, egy "succesfullyAddedCart" nevű változóba mentésre kerül a következő üzenet: "A terméket sikeresen a kosárba tettük!" Ezt követően törlésre kerül az elem.
A teszt állítása (Assertion) csak akkor fut le, ha igaz a feltevés (Assumption) miszerint a "succesfullyAddedCart" nevű változó tartalmazza a fent említett üzenetet.
-----

### TC6 Keresztnév módosítása
- modify_data/ModifyDataTest.java
- testModifyRegisteredName

A keresztnév módosításához be kell jelentkezni amihez szükséges teszt adat megadása.  
Példa:
loginPage.setUsernameField("elek.teszt.mail@gmail.com");  
loginPage.setPasswordField("Wsp331.");  
A setFirstName metódusnak paraméterként át kell adni egy string-et ami az új keresztnév, majd a jelszót kell begépelni.  
Példa:
```sh
myAccountPage.setFirstName("Áron");  
myAccountPage.setPassword("Wsp321.");  
myAccountPage.setPasswordAgain("Wsp321.");  
```
-----


### TC7 Márkaszűrő módosítása
- modify_data/ModifyDataTest.java
- testBrandFilter

Első lépésben a "pendrive" kifejezésre keres rá a script.
Egy változóba ("NumberOfBrandsBeforeFilter") mentésre kerül az elérhető márkák darabszáma.
A márka kereső mezőbe a következő kifejezés kerül beírásra: "adata", majd a ("NumberOfBrandsAfterFilter")
változóba mentésre kerül hogy hány darab márkát listáz a weboldal szűrés után.
A következő lépésben viszont a keresett márka módosításra kerül és egy márka részlet "ki" (sub string) íródik be.
A feljebb említett két változó egy olyan feltevéshez (Assumption) szükséges ami dönt az alapján, hogy ha a márkák száma kisebb szűrés után mint előtte, akkor az állítás (Assertion) lefut, és megvizsgálja, hogy a módosított szűrő által kilistázott márkák tartalmazzák -e a "ki" márka részletet.
-----

### TC8 Adott termék többoldalas listájának bejárása
- read_multipage_list/ReadMultiPageListTest.java
- MultiPageAppleProductFilterTest

A script a weboldalon kilistázza az elérhető iPhone-okat és iPad-eket. Az első oldalon megjelenő termékek nevét elmenti egy listába, majd
a következő oldalra lapoz, és szintén menti a neveket. Ez a folyamat addig ismétlődik, míg az utolsó oldalra nem érünk.
A feltevés (Assumption) amelynek igaznak kell lennie, hogy lefusson az állítás (Assertion) a következő: Több elemet tartalmaz a lista mint 36?
Egy oldal 36 elemet tartalmaz. Ha a feltevés igaz, akkor a listában a script megvizsgálja, hogy az elemek tartalmazzák-e az "Apple" kifejezést.
-----

### TC9 Feliratkozás hírlevélre
- input_data_from_source/SubscriptionForNewsLetterTest.java
- SubscriptionForNewsLetterTest

A teszt egy külső adatforrást használ ("input_data_test.json") a megfelelő mezők kitöltésére.
A file szerkeszthető és annyiszor történik feliratkozás, ahány user-t tartalmaz a json file.
-----

### TC10 Adatkezelési nyilatkozat megnyitása
- privacypolicy/PrivacyPolicyTest.java
- testCheckEachLineOfPrivacyPolicyTextFile

A kezdőoldal betöltését követően felugrik egy ablak ahol az Általános Szerződési Feltételeket kell elfogadni.
Ezen az ablakon keresztül a script átnavigál az Általános szerződési feltételekre, ahol a szerződés fejezetei mentésre kerülnek egy txt file-ba. A "PrivacyPolicyPage.java" osztály tartalmaz egy tömböt amely referenciaként tartalmazza a szükséges fejezet címeket.
Az állítás (Assertion) ellenőrzi a txt filet hogy tartalmazza -e a referencia tömben lévő fejezet címeket.
A scipt el is fogadja ezeket a feltételeket, a felugró ablakon az oké gombra történő kattintással.
-----

### TC11 Notebook szűrése
- save_data/ProductFilterTest.java
- FilterAppleNotebooksTest

A sciprt kiszűri az Apple notebook-okat, majd az első oldalon lévő termék neveket és árakat elmenti egy txt-fileba, majd megvizsgálja, hogy a sorok tartalmazzák -e a "macbook" kifejezést.
 









