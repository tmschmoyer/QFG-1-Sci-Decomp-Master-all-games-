;;; Sierra Script 1.0 - (do not remove this comment)
(script# 250)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Invent)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	nearSteps
	cantGoThere
	local2
	local3
	local4
	[str 200]
)
(procedure (TImedPrint &tmp seconds)
	(Print @str
		#at 10 5
		#width 290
		#time (= seconds (SetPrintTime @str))
		#dispose
	)
	(return (+ 3 seconds))
)

(instance rm250 of Room
	(properties
		picture 250
		south 260
	)
	
	(method (init)
		(if
		(and (ego has: iGinsuKnife) (== ((Inventory at: iGinsuKnife) view?) 2))
			(Load VIEW 251)
			(Load VIEW 709)
			(Load VIEW 2)
			(Load SOUND 250)
		)
		(if (== currentStatus 4) (self style: IRISOUT))
		(super init:)
		(self setScript: RoomScript)
		(if (not (Btst fFired))
			(Load VIEW 53)
		)
		(if (and (Btst fFired) (not (Btst fCredits250)))
			(Load VIEW 252)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(if (> machineSpeed 16) (aFountain init:))
		(cond 
			((== prevRoomNum 305) (ego posn: 2 186) (= local3 1))
			((== prevRoomNum 220) (ego posn: 2 122))
			((== prevRoomNum 253) (ego posn: 317 125))
			((== prevRoomNum 260) (ego posn: 154 187 loop: 3))
			(else (= nearSteps 1) (ego posn: 317 118 loop: 1))
		)
		(NormalEgo)
		(if nearSteps
			(ego setPri: 11 observeControl: cYELLOW init:)
		else
			(ego observeControl: cLMAGENTA init:)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (ego edgeHit?)
			(cond 
				((& (ego onControl:) cBLUE) (curRoom newRoom: 305))
				((& (ego onControl:) cCYAN) (curRoom newRoom: 220))
				((& (ego onControl:) cRED)
					(if nearSteps
						(curRoom newRoom: 400)
					else
						(curRoom newRoom: 253)
					)
				)
			)
		)
		(cond 
			((== nearSteps -1))
			((& (ego onControl:) cLRED)
				(= nearSteps 1)
			)
			((& (ego onControl:) cLCYAN)
				(= nearSteps 0)
			)
		)
		(if (== nearSteps 1)
			(ego setPri: 11 observeControl: cYELLOW ignoreControl: cLMAGENTA)
		)
		(if (== nearSteps 0)
			(ego
				setPri: -1
				ignoreControl: cYELLOW cRED
				observeControl: cLMAGENTA
			)
		)
		(if
			(and
				(& (ego onControl:) cBLUE)
				(or playingAsPatti (!= currentStatus egoNORMAL))
			)
			(if (not local3)
				(= local3 1)
				(ego
					posn: (ego xLast?) (ego yLast?)
					setMotion: 0
					observeControl: cBLUE
				)
				(if playingAsPatti (Print 250 0) else (Print 250 1))
				(Animate (cast elements?) FALSE)
			)
		else
			(= local3 0)
		)
		(if
			(and
				(& (ego onControl:) cRED)
				nearSteps
				(!= currentStatus egoSHOWGIRL)
				(!= currentStatus egoNORMAL)
			)
			(if (not local2)
				(= local2 1)
				(ego
					posn: (ego xLast?) (ego yLast?)
					setMotion: 0
					observeControl: cRED
				)
				(Print 250 2)
				(Animate (cast elements?) FALSE)
			)
		else
			(= local2 0)
		)
		(if (& (ego onControl:) cGREEN)
			(if (not cantGoThere)
				(= cantGoThere TRUE)
				(ShakeScreen 1 shakeSRight)
				(Print 250 3)
				(Print 250 4 #at -1 144)
			)
		else
			(= cantGoThere FALSE)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (Btst fFired)) (= cycles 25))
			)
			(1
				(Format @str 250 15)
				(= seconds (TImedPrint))
				(aCredit1 view: 53 posn: 0 156 setCycle: Forward init:)
				(= seconds 13)
			)
			(2
				(Format @str 250 16)
				(= seconds (TImedPrint))
			)
			(3
				(Format @str 250 17)
				(= seconds (TImedPrint))
			)
			(4
				(Bset fFired)
				(Format @str 250 18)
				(= seconds (TImedPrint))
			)
			(5
				(aCredit1 dispose:)
				(= seconds 0)
			)
			(6
				(Ok)
				(HandsOff)
				(= nearSteps -1)
				(ego illegalBits: 0 setMotion: MoveTo 278 134 self)
			)
			(7
				(ego
					view: 709
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: EndLoop self
				)
			)
			(8
				(Print 250 19 #icon 2 0 0)
				(= local4 0)
				(= seconds 2)
				(= oldSpeed (theGame setSpeed: 6))
			)
			(9
				(soundFX number: 250 loop: 1 play:)
				(ego view: 251 cel: 0 setCycle: EndLoop)
				(= cycles 7)
				(if (< (++ local4) 11) (-- state))
			)
			(10
				((Inventory at: iGinsuKnife) view: 21)
				(Format ((Inventory at: iGinsuKnife) name?) 250 20)
				(soundFX stop:)
				(theGame setSpeed: oldSpeed changeScore: 50)
				(ego view: 709 loop: 0 setCel: 255 setCycle: BegLoop self)
			)
			(11
				(NormalEgo)
				(= nearSteps FALSE)
				(Print 250 21)
				(Print 250 22)
			)
		)
	)
	
	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed?))
				modelessDialog
				(== (event message?) ENTER)
				(== (event type?) keyDown)
			)
			(event claimed: TRUE)
			(cls)
			(self cue:)
		)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if (Said 'caress,sharpen/ginsu>')
			(cond 
				((not (ego has: iGinsuKnife)) (DontHave))
				((== ((Inventory at: iGinsuKnife) view?) 21) (ItIs))
				((Said '/[/!*]') (Print 250 5))
				((Said '//fountain,barstool,barstool') (Print 250 6))
				((not (Said '//stair,carpet')) (Print 250 7))
				((not nearSteps) (Print 250 8))
				((!= currentStatus egoNORMAL) (GoodIdea))
				(else (self changeState: 6))
			)
			(event claimed: TRUE)
		)
		(if (Said 'look>')
			(cond 
				((Said '/palm,bush,carpet') (Print 250 9))
				((Said '/cannibal,office')
					(if playingAsPatti
						(Print 250 10 currentEgo)
					else
						(Print 250 11)
					)
				)
				((Said '/water,cascade,fountain') (Print 250 12))
				((Said '/stair,exit,carpet') (Print 250 13))
				((Said '[/area]') (Print 250 14))
			)
		)
	)
)

(instance aFountain of Prop
	(properties
		y 148
		x 194
		view 250
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Forward setPri: 11)
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 288
		view 252
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 288
		view 252
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(aCredit1 setCycle: EndLoop)
				(= cycles 13)
			)
			(2
				(aCredit2 setCycle: EndLoop)
				(= cycles 16)
			)
			(3
				(aCredit2 setCycle: BegLoop self)
			)
			(4
				(aCredit2 loop: 2 setCycle: EndLoop)
				(= cycles 16)
			)
			(5
				(aCredit2 setCycle: BegLoop self)
			)
			(6
				(aCredit2 loop: 3 setCycle: EndLoop)
				(= cycles 16)
			)
			(7
				(aCredit2 setCycle: BegLoop self)
			)
			(8
				(aCredit2 loop: 4 setCycle: EndLoop)
				(= cycles 16)
			)
			(9
				(Bset fCredits250)
				(aCredit1 setCycle: BegLoop)
				(aCredit2 setCycle: BegLoop self)
			)
			(10
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)
