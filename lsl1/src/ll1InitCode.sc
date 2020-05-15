;;; Sierra Script 1.0 - (do not remove this comment)
(script# LLINIT) ;816
(include game.sh)
(use Main)
(use LLRoom)
(use PMouse)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use User)
(use System)

(public
	ll1InitCode 0
)

(instance ll1InitCode of Code
	(properties)
	
	(method (init)
		(if (> (Graph GDetect) 16)
			(= myTextColor (Palette PALMatch 31 31 31))
			(= myTextColor2 (Palette PALMatch 63 63 63))
			(= myTextColor3 (Palette PALMatch 95 95 95))
			(= myTextColor4 (Palette PALMatch 127 127 127))
			(= myTextColor5 (Palette PALMatch 159 159 159))
			(= myTextColor6 (Palette PALMatch 191 191 191))
			(= myTextColor7 (Palette PALMatch 223 223 223))
			(= myTextColor8 (Palette PALMatch 151 27 27))
			(= myTextColor9 (Palette PALMatch 255 77 77))
			(= myTextColor10 (Palette PALMatch 235 135 135))
			(= myTextColor11 (Palette PALMatch 187 187 35))
			(= myTextColor12 (Palette PALMatch 219 219 39))
			(= myTextColor13 (Palette PALMatch 223 223 71))
			(= myTextColor14 (Palette PALMatch 15 87 15))
			(= myTextColor15 (Palette PALMatch 27 151 27))
			(= myTextColor16 (Palette PALMatch 71 223 71))
			(= myTextColor17 (Palette PALMatch 135 235 135))
			(= myInsideColor (Palette PALMatch 23 23 119))
			(= myScoreColor (Palette PALMatch 35 35 187))
			(= myHighlightColor (Palette PALMatch 71 71 223))
			(= myLowlightColor (Palette PALMatch 135 135 235))
			(= myTopBordColor (Palette PALMatch 219 39 219))
			(= myBotBordColor (Palette PALMatch 255 77 255))
			(= myLftBordColor (Palette PALMatch 27 151 151))
			(= myRgtBordColor (Palette PALMatch 77 255 255))
			(= myBackColor (Palette PALMatch 255 255 120))
		else
			(= myTextColor vBLACK)
			(= myTextColor2 vLGREY)
			(= myTextColor3 vGREY)
			(= myTextColor4 vLGREY)
			(= myTextColor5 vLGREY)
			(= myTextColor6 vLGREY)
			(= myTextColor7 vWHITE)
			(= myTextColor8 vRED)
			(= myTextColor9 vLRED)
			(= myTextColor10 vLRED)
			(= myTextColor11 vBROWN)
			(= myTextColor12 vYELLOW)
			(= myTextColor13 vYELLOW)
			(= myTextColor14 vGREEN)
			(= myTextColor15 vGREEN)
			(= myTextColor16 vLGREEN)
			(= myTextColor17 vLGREEN)
			(= myInsideColor vBLUE)
			(= myScoreColor vBLUE)
			(= myHighlightColor vLBLUE)
			(= myLowlightColor vLBLUE)
			(= myTopBordColor vMAGENTA)
			(= myBotBordColor vLMAGENTA)
			(= myLftBordColor vCYAN)
			(= myRgtBordColor vLCYAN)
			(= myBackColor vYELLOW)
		)
		(= numVoices (DoSound NumVoices))
		(if
			(and
				(>= (= numColors (Graph GDetect)) 2)
				(<= numColors 16)
			)
			(Bclr fIsVGA)
		else
			(Bset fIsVGA)
		)
		(= useSortedFeatures TRUE)
		PolyPath
		Polygon
		LLRoom
		(ScriptID SIGHT)
		(LoadMany VIEW 852 850 900)
		(LoadMany SOUND 821)
		(User
			alterEgo: ego
			verbMessager: 0
			canControl: FALSE
			canInput: FALSE
		)
		(theGame setCursor: theCursor TRUE 304 172)
		(systemWindow color: vBLACK back: myBackColor)
		(= pMouse PseudoMouse)
		(= eatMice 3)
		(= waitCursor HAND_CURSOR)
		(= score 0)
		(= possibleScore 222)
		(= currentTime -24576)
		;EO: currentTime can't be $6000; that will set the time to 6:00, causing the suicide
		; (yes, it IS in this version of the game!) at the starting room
		(= spraySeconds 600)
		(= dollars 94)
		(= bigFont 2108)
		(= userFont 2107)
		(= smallFont 1207)
		(= editFont 2407)
		(= giantFont 4115)
		(LoadMany FONT SYSFONT userFont bigFont smallFont)
	)
)
