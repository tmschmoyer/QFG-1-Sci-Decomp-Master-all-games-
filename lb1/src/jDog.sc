;;; Sierra Script 1.0 - (do not remove this comment)
(script# 386)
(include sci.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use System)

(public
	jDog 0
)

(instance jDog of Script
	(properties)
	
	(method (init)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (and (== state 3) (== (gDoor cel?) 4))
			(gBdoor show: ignoreActors: 1 stopUpd:)
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 985)
		(DisposeScript 386)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= prevRoomNum 35)
					(gDoor_2 setCycle: End self)
					(gMyMusic number: 43 loop: 1 priority: 5 play:)
				else
					(= cycles 1)
				)
			)
			(1
				(gDoor
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
				)
				(if (!= prevRoomNum 35)
					(gDoor setMotion: MoveTo 196 141 self init:)
				else
					(= cycles 1)
				)
			)
			(2
				(if (!= prevRoomNum 35)
					(gDoor_2 setCycle: Beg)
					(gMyMusic number: 44 loop: 1 priority: 5 play:)
				)
				(Print 386 0 #at 175 15 #font 4 #dispose)
				(gDoor setMotion: MoveTo 216 161 self)
			)
			(3
				(cls)
				(gDoor_2 stopUpd:)
				(gDoor view: 445 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(gDoor view: 440 setMotion: MoveTo 140 248 setCycle: Walk)
				(gMySound
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 224 159 self
				)
			)
			(5
				(gMySound view: 526 setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(gMySound setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(7
				(gMySound
					setLoop: 0
					cel: (- (NumCels gMySound) 1)
					setPri: 11
					setCycle: Beg self
				)
			)
			(8
				(gMySound
					view: 520
					setLoop: -1
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 160 156 self
				)
				(gDoor dispose:)
			)
			(9
				(HandsOn)
				(= [global368 2] 1800)
				(= global162 1)
				(= global155 2)
				(gBdoor ignoreActors: 0)
				(= saveDisabled 0)
				(client setScript: 0)
			)
		)
	)
)
