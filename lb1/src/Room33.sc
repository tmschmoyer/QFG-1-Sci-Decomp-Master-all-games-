;;; Sierra Script 1.0 - (do not remove this comment)
(script# 33)
(include sci.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Avoider)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room33 0
)
(synonyms
	(room hall)
	(armoire armoire closet)
)

(local
	local0
	local1
	local2
	theCSound
	local4
)
(procedure (localproc_000c)
	(if (< (ego distanceTo: Mirror) 50)
		(= theTalker 12)
		(Say 0 33 0)
	else
		(NotClose)
	)
)

(instance Room33 of Rm
	(properties
		picture 33
	)
	
	(method (init)
		(= horizon 95)
		(= north 4)
		(= south 37)
		(super init:)
		(LoadMany 128 33 103)
		(LoadMany 132 43 44 71 72)
		(clockFace init: hide:)
		(hourHand init: hide:)
		(minuteHand init: hide:)
		(if howFast
			(mirrorImage setPri: 12 init:)
			(lampL setPri: 4 setCycle: Fwd init:)
			(lampR setPri: 4 setCycle: Fwd init:)
		else
			(lampL addToPic:)
			(lampR addToPic:)
		)
		(addToPics add: lamp phone eachElementDo: #init doit:)
		(if
			(and
				(or (not (Btst 41)) (not (Btst 42)) (not (Btst 43)))
				(> currentAct 0)
			)
			(= local4 1)
			(Load rsVIEW 925)
			(LoadMany 143 412)
		)
		(Clock stopUpd: ignoreActors: 1 init:)
		(if
			(and
				(== currentAct 2)
				(== global143 0)
				(== global144 0)
				(== global139 0)
				(== global140 0)
			)
			(Clock cel: 1 ignoreActors: 0)
		)
		(= theCSound cSound)
		(if (!= prevRoomNum 33)
			(theCSound number: 28 loop: -1 play:)
		)
		(Mirror stopUpd: ignoreActors: 1 init:)
		(rDoor
			cel: (if (== prevRoomNum 4) 2 else 0)
			init:
			stopUpd:
		)
		(lDoor
			cel: (if (== prevRoomNum 4) 2 else 0)
			stopUpd:
			init:
		)
		(self setFeatures: phone lamp Case2 Case1)
		(ego view: 0 illegalBits: -32762 init:)
		(switch prevRoomNum
			(4
				(rDoor setCycle: Beg)
				(lDoor setCycle: Beg)
				(ego posn: 159 110 setMotion: MoveTo 159 118)
				(mySound loop: 1 play:)
			)
			(32 (ego posn: 68 135))
			(34
				(ego setPri: -1 posn: 254 136)
			)
			(49
				(ego ignoreControl: 2 posn: 52 165)
				(Clock cel: (- (NumCels Clock) 1) setScript: CloseClock)
			)
			(50
				(ego posn: 266 159 ignoreControl: 4)
				(Mirror
					cel: (- (NumCels Mirror) 1)
					setScript: CloseMirror
				)
			)
		)
	)
	
	(method (doit)
		(if (FirstEntry) (Print 33 1))
		(if local4
			(HandsOff)
			(= local4 0)
			(self setScript: (ScriptID 412 0))
		)
		(if
			(and
				(& (ego onControl: 1) $0020)
				(not local1)
				(== (ego loop?) 3)
			)
			(HandsOff)
			(= local1 1)
			(self setScript: myDoor)
		)
		(switch (ego onControl: 1)
			(16 (curRoom newRoom: 32))
			(8 (curRoom newRoom: 34))
		)
		(cond 
			((< (ego x?) 130) (= vertAngle 20))
			((< (ego x?) 190) (= vertAngle 0))
			(else (= vertAngle 160))
		)
		(if
			(and
				(== prevRoomNum 4)
				(== (lDoor cel?) 0)
				(== (rDoor cel?) 0)
				(not local2)
			)
			(= local2 1)
			(lDoor stopUpd:)
			(rDoor stopUpd:)
		)
		(if (and (> (ego y?) 149) (< (ego y?) 161))
			(mirrorImage loop: 6 cel: (- 160 (ego y?)) forceUpd:)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 200)
		(DisposeScript 985)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)
		(if (event claimed?) (return 1))
		(return
			(if (== (event type?) evSAID)
				(cond 
					((Said 'examine>')
						(cond 
							((Said '[<around,at][/room]') (Print 33 1))
							((Said '/door<hidden') (Print 33 2))
							((Said '/door<front') (Print 33 3))
							((Said '/reflection[/mirror]') (localproc_000c))
							((Said '/door') (Print 33 4))
							((Said '/pendulum') (Print 33 5))
							((or (Said '/dirt') (Said '<down')) (Print 33 6))
						)
					)
					(
						(or
							(Said 'move/clock')
							(Said '(drag,press)[<open,on]/clock')
						)
						(HandsOff)
						(self setScript: MoveClock)
					)
					((Said 'close/clock,mirror') (AlreadyClosed))
					(
						(or
							(Said 'rotate,move/mirror')
							(Said '(press,drag)[<open,on]/mirror')
						)
						(HandsOff)
						(self setScript: PushMirror)
					)
					((Said 'unbar/armoire')
						(if
							(or
								(ego inRect: 72 106 111 121)
								(ego inRect: 207 106 252 121)
							)
							(Print 33 7)
						else
							(NotClose)
						)
					)
					((Said 'break/mirror') (Print 33 8))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom n)
		(if (and (== theCSound cSound) (!= n 37))
			(theCSound stop:)
		)
		(super newRoom: n)
	)
)

(instance MoveClock of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego
					observeControl: 16
					setAvoider: (Avoid new:)
					setMotion: MoveTo 85 165 self
				)
			)
			(1
				(ego loop: 1 ignoreControl: 2)
				(Clock cycleSpeed: 3 setCycle: End self)
				(mySound number: 71 loop: 1 play:)
			)
			(2
				(if (== global139 0) (Print 33 9 #at 76 40))
				(Clock stopUpd:)
				(ego setMotion: MoveTo 46 165 self)
			)
			(3
				(HandsOn)
				(ego setAvoider: 0)
				(client setScript: 0)
				(curRoom newRoom: 49)
			)
		)
	)
)

(instance CloseClock of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego ignoreControl: 2 setMotion: MoveTo 85 165 self)
			)
			(1
				(Clock cycleSpeed: 3 setCycle: Beg self)
				(mySound number: 71 loop: 1 play:)
			)
			(2
				(Clock stopUpd:)
				(ego illegalBits: -32762)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance PushMirror of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego
					setAvoider: (Avoid new:)
					setMotion: MoveTo 256 159 self
				)
			)
			(1
				(ego loop: 0 cel: 1 ignoreControl: 4)
				(Mirror cycleSpeed: 3 setCycle: End self)
				(mySound number: 72 loop: 1 play:)
			)
			(2
				(if (== global140 0) (Print 33 10 #at 70 36))
				(Mirror stopUpd:)
				(ego
					view: 33
					loop: 0
					cel: 0
					posn: 266 159
					setPri: 13
					setCycle: End self
				)
				(if howFast (mirrorImage loop: 7 cel: 0 setCycle: End))
			)
			(3
				(HandsOn)
				(ego setAvoider: 0)
				(client setScript: 0)
				(curRoom newRoom: 50)
			)
		)
	)
)

(instance CloseMirror of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					view: 33
					loop: 2
					cel: 0
					posn: 266 159
					setPri: 13
					setCycle: End self
				)
				(if howFast (mirrorImage loop: 7 cel: 0 setCycle: End))
			)
			(1
				(ego
					view: 0
					loop: 1
					cel: 0
					posn: 257 159
					setPri: -1
					setCycle: Walk
					observeControl: 4
				)
				(Mirror cycleSpeed: 3 setCycle: Beg self)
				(mySound number: 72 loop: 1 play:)
			)
			(2
				(ego illegalBits: -32762)
				(Mirror stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(if (ego inRect: 155 100 165 110)
					(ego setMotion: MoveTo 159 115 self)
				else
					(= cycles 1)
				)
			)
			(2
				(ego loop: 3)
				(rDoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(lDoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(mySound number: 43 loop: 1 play:)
			)
			(3
				(ego setMotion: MoveTo 157 88)
			)
		)
	)
)

(instance ShowTime of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if howFast
					(clockFace cel: 0 setCycle: End self show:)
				else
					(clockFace cel: 5 show:)
					(= cycles 1)
				)
			)
			(1
				(hourHand
					loop: (if (> gameMinutes 1) 7 else 6)
					cel: (if (== gameHours 12) 0 else gameHours)
					show:
				)
				(minuteHand loop: (if (< gameMinutes 2) 2 else 5))
				(minuteHand
					cel: (if (& gameMinutes $0001)
						(- (NumCels minuteHand) 1)
					else
						0
					)
					show:
				)
				(= cycles 4)
			)
			(2
				(Print 33 11 #at 10 130)
				(= cycles 1)
			)
			(3
				(hourHand hide:)
				(minuteHand hide:)
				(if howFast
					(clockFace setCycle: Beg self)
				else
					(clockFace hide:)
					(= cycles 1)
				)
			)
			(4
				(clockFace hide:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance lamp of RPicView
	(properties
		y 189
		x 45
		view 133
		priority 14
	)
	
	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(ParseName {table})
		)
	)
)

(instance phone of RPicView
	(properties
		y 189
		x 277
		view 133
		cel 1
		priority 14
	)
	
	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(ParseName {table})
		)
	)
)

(instance Clock of Prop
	(properties
		y 160
		x 53
		view 233
		priority 12
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine/archway')
				(if (== (Clock cel?) 1)
					(Print 33 12)
				else
					(event claimed: 1)
				)
			)
			((Said 'hear/clock') (Print 33 13))
			((Said 'open,(examine<(in,in,in))/clock')
				(if (< (ego distanceTo: Clock) 30)
					(Print 33 14)
				else
					(NotClose)
				)
			)
			((Said 'examine<behind/clock')
				(if (< (ego distanceTo: Clock) 30)
					(if (== (Clock cel?) 1)
						(Print 33 15)
					else
						(Print 33 16)
					)
				else
					(NotClose)
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'read,examine[<at]/clock,time')
				)
				(event claimed: 1)
				(if (== (Clock cel?) 1)
					(Print 33 17)
				else
					(self setScript: ShowTime)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance Mirror of Prop
	(properties
		y 154
		x 275
		view 233
		loop 1
		priority 13
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open/mirror') (Print 33 18))
			((Said '(examine<(in,in))/mirror') (localproc_000c))
			((Said 'examine<behind/mirror')
				(if (< (ego distanceTo: Mirror) 30)
					(Print 33 19)
				else
					(NotClose)
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'examine[<at]/mirror')
				)
				(Print 33 20)
				(event claimed: 1)
			)
		)
	)
)

(instance mirrorImage of Prop
	(properties
		y 142
		x 268
		view 233
		loop 6
	)
)

(instance rDoor of Prop
	(properties
		y 100
		x 183
		view 233
		loop 2
		priority 6
	)
	
	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(ParseName {door})
		)
	)
)

(instance lDoor of Prop
	(properties
		y 100
		x 133
		view 233
		loop 3
		priority 6
	)
	
	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(ParseName {door})
		)
	)
)

(instance lampL of Prop
	(properties
		y 81
		x 76
		view 233
		loop 4
		cel 1
		priority 4
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event 3)
				(Said 'examine/curtain<lamp')
			)
			(event claimed: 1)
			(ParseName {lamp})
		)
	)
)

(instance lampR of Prop
	(properties
		y 81
		x 247
		view 233
		loop 5
		priority 4
	)
	
	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(ParseName {lamp})
		)
	)
)

(instance clockFace of Prop
	(properties
		y 106
		x 47
		view 103
		loop 1
		priority 14
		signal $4010
		cycleSpeed 1
	)
)

(instance hourHand of Prop
	(properties
		y 73
		x 81
		view 103
		priority 15
		signal $4010
		cycleSpeed 1
	)
)

(instance minuteHand of Prop
	(properties
		y 73
		x 81
		view 103
		priority 15
		signal $4010
		cycleSpeed 1
	)
)

(instance Case1 of RFeature
	(properties
		nsTop 43
		nsLeft 77
		nsBottom 104
		nsRight 110
	)
	
	(method (handleEvent event)
		(if
		(or (MousedOn self event 3) (Said 'examine/armoire'))
			(Print 33 21)
			(event claimed: 1)
		)
	)
)

(instance Case2 of RFeature
	(properties
		nsTop 43
		nsLeft 206
		nsBottom 104
		nsRight 244
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/drawer') (Print 33 22))
			((Said 'move/armoire') (Print 33 23))
			((Said 'open,(examine<in)/armoire')
				(if
					(or
						(ego inRect: 72 106 111 121)
						(ego inRect: 207 106 252 121)
					)
					(Print 33 24)
				else
					(NotClose)
				)
			)
			(
			(or (MousedOn self event 3) (Said 'examine/armoire')) (Print 33 21) (event claimed: 1))
		)
	)
)

(instance mySound of Sound
	(properties
		number 44
		priority 5
	)
)
