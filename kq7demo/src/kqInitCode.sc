;;; Sierra Script 1.0 - (do not remove this comment)
(script# KQINIT)
(include game.sh)
(use Main)
(use Procs)
(use KQEgo)
(use Styler)
(use String)
(use Print)
(use Talker)
(use User)
(use System)

(public
	kqInitCode 0
)

(instance kqInitCode of Code

	(method (doit &tmp temp0 debugFile)
		(= debugFile (String newWith: 16 {}))
		(= userFont 4)
		(User alterEgo: KQEgo canControl: FALSE canInput: FALSE)
		(Narrator x: -1 y: 0 modeless: 2)
		(= demoScripts TRUE)
		(if (DoSound SndNumDACs)
			(= msgType (| TEXT_MSG CD_MSG))
		else
			(= msgType TEXT_MSG)
		)
		(= useSortedFeatures TRUE)
		(Styler divisions: 20)
		(= score 0)
		(Print font: 999 back: 0 fore: 53 skip: 250)
		(if (IsHiRes)
			(Bset fIsHiRes)
			(SetFontRes 640 480)
		)
		(= numVoices (DoSound SndNumVoices))
		(debugFile format: {%d.scr} 99)
		(if (FileIO FileExists (debugFile data?))
			(= debugging TRUE)
		else
			(= debugging FALSE)
		)
		(debugFile dispose:)
		(= eatMice 2)
		(DisposeScript KQINIT)
	)
)
