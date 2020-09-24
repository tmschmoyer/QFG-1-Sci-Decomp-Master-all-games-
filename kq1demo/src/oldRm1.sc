;;; Sierra Script 1.0 - (do not remove this comment)
(script# rOldRm1)
(include game.sh)
(use Main)
(use Intrface)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	oldRm1 0
)

(instance oldRm1 of Room
	(properties
		picture rOldRm1
		west rOldRm2
	)
	
	(method (init)
		(LoadMany VIEW vEgoAGI vFlagsAGI vAlligator)
		(super init:)
		(flags
			init:
			setCycle: (if (!= howFast slow) Forward else 0)
		)
		(alligator1 init: setScript: moveAlligator1)
		(alligator2 init: setScript: moveAlligator2)
		(ego
			init:
			view: vEgoAGI
			x: 304
			y: 151
			loop: 1
			setCycle: Walk
			setScript: welcomeEgo
		)
		(DisplayOldGraphics)
		(HandsOff)
	)
	
	(method (doit)
		(super doit:)
	)
)

(instance welcomeEgo of Script

	(method (doit)
		(super doit:)
		(if (== (ego x?) 219)
			(Print 501 0
				#at 25 20
				#width 260
				#mode teJustCenter
				#dispose
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego setMotion: MoveTo 241 151 self)
			)
			(1
				(ego setMotion: DPath
					219 153
					206 164
					199 171
					5 171
					self
				)
			)
			(2
				(cls)
				(ego setMotion: MoveTo -1 171)
			)
		)
	)
)

(instance moveAlligator1 of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alligator1
					setCycle: 0
					cel: 0
					setMotion: MoveTo (Random 33 182) 184 self
				)
				(= cycles (Random (Random 8 20) (Random 25 30)))
			)
			(1
				(= cycles 0)
				(alligator1 setCycle: Forward setMotion: 0)
				(= cycles (Random (Random 4 9) (Random 12 15)))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance moveAlligator2 of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(alligator2
					setCycle: 0
					cel: 0
					setMotion: MoveTo (Random 33 182) 186 self
				)
				(= cycles (Random (Random 8 20) (Random 25 30)))
			)
			(1
				(= cycles 0)
				(alligator2 setCycle: Forward setMotion: 0)
				(= cycles (Random (Random 4 9) (Random 12 15)))
			)
			(2 (self changeState: 0))
		)
	)
)

(instance flags of Actor
	(properties
		x 51
		y 18
		view vFlagsAGI
		cel 2
		moveSpeed 3
	)
)

(instance alligator1 of Actor
	(properties
		x 191
		y 185
		view vAlligator
	)
)

(instance alligator2 of Actor
	(properties
		x 161
		y 185
		view vAlligator
	)
)
