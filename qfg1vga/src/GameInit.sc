;;; Sierra Script 1.0 - (do not remove this comment)
(script# HQINIT)
(include game.sh) (include "1.shm") (include "999.shm")
(use Main)
(use Procs)
(use Print)
(use Talker)
(use User)
(use System)

(public
	GameStartRoom 0
	InitGlobals 1
)

(procedure (GameStartRoom &tmp nr [str 10] [scriptNum 10] [debugNum 10])
	(User alterEgo: ego)
	(= showStyle HSHUTTER)
	(= debugging TRUE) ;added to enable debug features
	(= useSortedFeatures TRUE)
	(= msgType TEXT_MSG)
	(= possibleScore 500)
	(= smallFont 999)
	(= bigFont 300)
	(= stamCounter STAM_RATE)
	(= healCounter HEAL_RATE)
	(= manaCounter MANA_RATE)
	(Format @userName {Unknown Hero})
	((= narrator Narrator)
		x: -1
		y: 14
		keepWindow: TRUE
		font: (= userFont 300)
		color: 66
		back: 69
	)
	(InitGlobals)
	(FixTime 11)
	(HandsOn)
	(if (HaveMouse)
		(= eatMice 30)
		(theGame setCursor: normalCursor TRUE)
	else
		(theGame setCursor: normalCursor TRUE 304 174)
	)
	(Bset fSaveAllowed)
	(Joystick JoyRepeat 0)
	(= str (= scriptNum (= debugNum 0)))
	(Message MsgGet SYSTEM N_CUE NULL C_SCRIPT_NUM 1 @scriptNum)
	(Format @debugNum @scriptNum DEBUG)
	(if (or debugging (FileIO fileExists @debugNum))
		(= nr
			(Print
				addText: N_ROOM NULL C_WHERETO 1 0 0 HQINIT
				addEdit: @str 5 115 0
				addButton: 200 N_ROOM NULL NULL 1 0 12 HQINIT
				addButton: 202 N_ROOM NULL NULL 2 100 12 HQINIT
				addButton: -100 N_ROOM NULL NULL 3 0 26 HQINIT
				addButton: 300 N_ROOM NULL NULL 4 100 26 HQINIT
				addButton: NOTICE N_ROOM NULL NULL 5 0 40 HQINIT
				init:
			)
		)
	else
		(= nr 2)
	)
	(if (== nr -100)
		(theGame restore:)
	)
	(if (not (OneOf nr 200 202 300 2))
		(= nr 300)
	)
	(if str (= nr (ReadNumber @str)))
	(= startingRoom nr)
	(theGame newRoom: SPEED)
)

(procedure (InitGlobals)
	(= numVoices (DoSound NumVoices))
	;remnants from EGA
	(if (< (= numColors (Graph GDetect)) 8)
		(= statusBarView vMonoStatusBar)
		(= sameColor vBLACK)
		(= changeColor vRED)
	else
		(= statusBarView vStatusBar)
		(= sameColor 42)
		(= changeColor 54)
	)
)
