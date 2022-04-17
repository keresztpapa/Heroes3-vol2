# Heroes3-vol2

[ Beüzemelés ] 

 - Java 17 kell és Intellij

   - Első indításkor, ha feltételezhetően nincs javafx a gépen.
     - Le kell tölteni a javafx package-et a hivatalos oldalról. <br> ( https://gluonhq.com/products/javafx/ ) innen
       - A java JDK -k mellé érdemes kicsomagolni a javafx -et, ez operációs rendszerenként eltér.
         - ez linuxon a /usr/bin/java
         - windows-on a C://programfiles/java
     - JavaFX lib hozzáadása
       - InelliJ-n belül <i> File -> Project Structure -> Project Settings -> Libraries ->  +  </i>
       - Ezután ki kell választani a Javafx-et onann ahova ki lett csomagolva
       - IntelliJ ujraindítása
       - Ezután  <i>  Run -> Edit Configurations -> Modify options -> add VM options  </i>,  és megkell adnunk a lib elérési útvonalat <br><b> --modula-path "útvonal" </b> leírássa.
       - utána ugyanannak az input field-et le kell nyitni és beírni még egy sort:
         -<b> --add-modules=javafx.controls,javafx.fxml </b>
 - Még annyit kell tennünk amikor megnyitjuk a projektet, a  <i> Run -> Edit Configurations  </i> menüpontban meg kell adni a main class-t.
   - Ezzel az az egyszerű dolgunk, a browse gomb lenyomása után elkezdi scan-elni a projektet és megtalálja magának.
     - Ha valamiért mégse tenné a Main.class <b> com.example.prog1demo.Application </b>.
     - Ez a használt package rendszeren kívül van, könnyen megtalálható helyen. A <i>/src/main/java/com/example/prog1demo</i> mappában.

[ Használat ]

Indításkor feljön a játék menüje.
Itt kiválasztható, hogy single vagy multiplayer legyen a game mode.

 - Multiplayer:
     Előre beállított egység értékekkel zajlik le a harc, a hős módosítói nem számítanak bele a csatába.
     Mindkét hősnek megvan mind a 3 varázslat.
    Illetve minden egyéségből adott számú van.
	
   - Single:
       Első lépésnek ki kell választani az adott nehézségi fokozatot.
      A nehézségi fokozat a hős aranyát befolyásolja. 
              Easy - 1300 arany
            Medium - 1000 arany
              Hard - 700  arany
	        
          Ha a legnehezebb módot szeretnénk választani, akkor a preparation gomb kell.
          Az annyira nehéz hogy nem lesz aranya a hősnek.
          Emiatt egysége sem.
      Bármelyik nehézséget választjuk az átdob, a skill pont vásárlás ablakra.
      Itt látjuk mennyi aranyunk van.
      Illetve tudunk venni skill pontot aranyért, minden darabot egyre drágábban.
      Ha elfogyott a pénzünk vagy egy skill-en 10 pont van akkor nem lehet többet venni.
          + egy skill-en 0nál kevesebb pont nem lehet.
      Oldalt látható az elenfél skill lapja. 10 pontott kapott véletlenszerűen elosztva.
	 
      Következő oldalon lehet megvenni a varázslatokat.
      Mindegyiket maximum egyszer.
      Látható az ára és a mana költsége.
	
      Utolsó lap az egységek vásárlása.
      -/+ jelekkel tudunk venni és eladni unit-ot.
      Látható, hogy mennyi darab van már eddig és, hogy mennyi aranyunk van még.
	
 - Csata:
 
     A csata körökre van osztva.
     A játékos minden megvásárolt egysége látható, az ellenfélnek minding lesz minden egység tipusból.
     Az adott egység tud mozogni, támadni és passzolni.
     Ha támad akkor elég közel kell, hogy legyen az adott ádozathoz.
     Ha passzol akkor a sorban jövő következő egységre ugrik a kör.
     Ha mozog akkor van egy maximális hatótávja. 
 	
	
[ Good to know ]

- A csata azzal indul, hogy rá kell nyomni a pass gombra. <br> Ebben az esetben most a legleső indexűre fog ugrani a kör.
	
- Nagyon fontos, hogy az egységet amit meg akarunk támadni, akor az egységre kattintsunk 
    és ne az egység alatti mezőre.
	

