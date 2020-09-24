;;; Sierra Script 1.0 - (do not remove this comment)
(script# dmDragon)
(include game.sh)
(use Main)
(use Intrface)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm551 0
)

(local
	local0
)
(instance rm551 of Room
	(properties
		picture dmDragon
		style (| IRISOUT BLACKOUT)
		east rOldRm2
		west rDragonCave
	)
	
	(method (init)
		(LoadMany VIEW vDragonAGI vPoof)
		(Load SOUND 45)
		(super init:)
		(ego
			init:
			hide:
			view: vEgo
			setCycle: StopWalk vEgoStand
			x: 267
			y: 147
		)
		(curRoom setScript: enterEgo)
		(dragon1 init:)
		(HandsOff)
		(= local0 2)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
	)
)

(instance moveAwayFromEgo of Script
	
	(method (doit)
		(super doit:)
		(if (and (< (ego x?) 5) modelessDialog)
			(modelessDialog dispose:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 6) number: 45 loop: -1 play:)
				(-- local0)
				(dragon1 setLoop: 2 setCycle: EndLoop self)
			)
			(1
				(if local0
					(if (== local0 1)
						(DisplayOldGraphics)
					)
					(self changeState: 0)
				else
					(= cycles 1)
				)
			)
			(2
				(Print 551 0
					#at 25 20
					#width 260
					#mode teJustCenter
					#dispose
				)
				(dragon1
					loop: 1
					setCycle: Walk
					setMotion: MoveTo -25 (ego y?)
				)
				(ego setMotion: MoveTo -5 (- (ego y?) 2))
			)
			(3 (self dispose:))
		)
	)
)

(instance enterEgo of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(poof
					init:
					x: 267
					y: 147
					priority: 12
					signal: fixPriOn
					setCycle: EndLoop self
				)
			)
			(1
				(ego
					show:
					x: 267
					y: 147
					loop: loopW
					setCycle: StopWalk 2
					priority: 12
					signal: fixPriOn
				)
				(poof setCycle: BegLoop self)
			)
			(2
				(curRoom setScript: moveAwayFromEgo)
			)
		)
	)
)

(instance dragon1 of Actor
	(properties
		x 160
		y 151
		view vDragonAGI
		loop 2
		priority 12
		signal fixPriOn
	)
)

(instance poof of Prop
	(properties
		z 26
		view vPoof
	)
)
