# GiocoRpg
Applicazione desktop con Java SE che simula un gioco RPG

---

# DOCUMENTAZIONE DEL PROGETTO RPG

## 1. STRUTTURA GENERALE

Il progetto è organizzato in modo completamente orientato agli oggetti, con una gerarchia chiara:

* **Personaggio** → classe padre  
  * **Eroe** → classe astratta per gli eroi  
    * Arciere  
    * Guerriero  
    * Mago  
    * Paladino  
  * **Nemico** → classe base dei nemici  
    * Boss → estende Nemico  
      * BossFinale → estende Boss  

Accanto a questi elementi principali ci sono:

* **Party** → gestisce i 4 eroi  
* **Dungeon** → dungeon casuale  
* **DungeonFinale** → dungeon con boss finale predefinito  
* **Combattimento** e **AzioneTurno** → regolano i turni di battaglia  
* **Commerciante** → acquisto pozioni e miglioramenti  
* **Enum** → tipi di danno, tipi di nemico, sesso, incantesimi, ecc.  
* **Main** → ciclo principale dell’avventura  

---

# 2. CLASSI PRINCIPALI

## 2.1 Personaggio (classe padre)

Rappresenta qualunque entità che può combattere.

Contiene:

* nome  
* punti vita  
* attacco  
* difesa  
* tipo di danno (ENUM)  
* metodi comuni: attacca(), subisciDanno(), èVivo(), cura(), ecc.

È la base per Eroe e Nemico.

---

## 2.2 Eroe (classe astratta)

Estende Personaggio.

Aggiunge:

* mana (per maghi o abilità speciali)  
* inventario condiviso (pozioni tramite Party)  
* metodi astratti o sovrascritti per abilità speciali  

Non può essere istanziata direttamente.

### Classi che estendono Eroe

#### Arciere
* Alto attacco a distanza  
* Bassa difesa  
* Critici più frequenti  

#### Guerriero
* Alta difesa  
* Attacco fisico costante  
* Può ridurre i danni subiti  

#### Mago
* Attacchi magici basati su TipoIncantesimo  
* Mana per incantesimi  
* Difesa bassa  

#### Paladino
* Difesa alta  
* Può curare sé stesso o il party  
* Attacco medio  

---

## 2.3 Nemico

Estende Personaggio.

Rappresenta i nemici base generati nei dungeon.

Caratteristiche:

* statistiche generate casualmente  
* tipo di nemico (ENUM)  
* tipo di danno (ENUM)  

---

## 2.4 Boss

Estende Nemico.

Caratteristiche:

* statistiche più alte  
* abilità speciali  
* nome generato casualmente tramite GeneratoreNomeBoss  

---

## 2.5 BossFinale

Estende Boss.

Caratteristiche:

* nome predefinito  
* statistiche fisse e molto elevate  
* abilità uniche  
* rappresenta il nemico finale del gioco  

---

# 3. PARTY E GESTIONE EROI

## 3.1 Party

Classe che gestisce i quattro eroi.

Caratteristiche:

* array statico di 4 eroi  
* creato direttamente nella classe Party  
* possibilità di combinare liberamente Arciere, Guerriero, Mago, Paladino  
* metodi:  
  * tuttiVivi()  
  * curaParty()  
  * mostraStatistiche()  
  * usaPozione()  

Risorse condivise:

* oro  
* pozioni  
* miglioramenti acquistati dal commerciante  

---

# 4. DUNGEON E GENERAZIONE CASUALE

## 4.1 Dungeon

Classe che rappresenta un dungeon casuale.

Genera:

* numero casuale di nemici  
* statistiche casuali dei nemici  
* tipo di nemico (ENUM)  
* tipo di danno (ENUM)  
* nome del dungeon tramite GeneratoreNomiDungeon  
* oro ottenibile  

---

## 4.2 DungeonFinale

Estende Dungeon.

Differenze:

* nemici predefiniti  
* boss finale predefinito  
* nome fisso  
* difficoltà massima  

È l’obiettivo finale del gioco.

---

# 5. COMBATTIMENTO

## 5.1 Combattimento

Gestisce l’intero flusso della battaglia.

Caratteristiche:

* i 4 eroi attaccano  
* i nemici attaccano  
* si procede finché una delle due parti non è sconfitta  
* gestisce l’ordine dei turni  
* interagisce con AzioneTurno  

---

## 5.2 AzioneTurno

Gestisce la singola azione scelta dal giocatore:

* attacca  
* difendi  
* curati  
* scegli il nemico da colpire  

Controlla:

* danni inflitti  
* danni subiti  
* cura applicata  
* eventuali bonus/malus  

---

# 6. COMMERCIANTE

Classe che permette al party di:

* comprare pozioni  
* comprare miglioramenti  
* spendere oro guadagnato nei dungeon  

L’oro è condiviso dal party.

---

# 7. ENUM UTILIZZATI

Il progetto utilizza vari ENUM per rendere il gioco più modulare:

* **Sesso** → maschio/femmina  
* **TipoDanno** → fisico, magico, fuoco, ghiaccio, ecc.  
* **TipoIncantesimo** → cura, attacco, buff, debuff  
* **TipoNemico** → orco, scheletro, demone, ecc.  

Gli ENUM vengono usati per:

* generare casualmente nemici  
* definire attacchi  
* creare incantesimi  
* generare nomi  

---

# 8. MAIN E CICLO DI GIOCO

Nel main è presente un **do-while** che controlla:

* se il party è ancora vivo  
* se il dungeon finale è stato completato  

Il giocatore può:

* entrare subito nel dungeon finale  
* esplorare dungeon casuali  
* visitare il commerciante  
* controllare lo stato del party  

Il ciclo continua finché:

* il party muore  
* il boss finale viene sconfitto  

---

# 9. FUNZIONALITÀ FUTURE

Il progetto già simula bene un RPG, ma è possibile creare estensioni per:

* sistema di esperienza  
* livelli  
* nuove classi di armi e armature  
* potenziamenti più complessi  
* abilità uniche per ogni classe  
* nuovi tipi di dungeon  

---

# CONCLUSIONE

Il progetto rappresenta un RPG completo e funzionante, con:

* ereditarietà ben strutturata  
* dungeon casuali  
* boss finale  
* party di eroi  
* combattimenti a turni  
* commerciante  
* enum per generazione casuale  
* ciclo di gioco completo  
