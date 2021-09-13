;;; Sierra Script 1.0 - (do not remove this comment)
(script# 53)
(include sci.sh)
(use Main)
(use Door)
(use AirplaneActor)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm53 0
)

(local
	local0
)
(instance theSound of Sound
	(properties
		number 5
		loop -1
	)
)

(instance rm53 of Rm
	(properties
		picture 53
		horizon 5
		east 54
		west 52
	)
	
	(method (init)
		(Load rsVIEW 513)
		(Load rsVIEW 514)
		(Load rsVIEW 511)
		(super init:)
		(addToPics add: aAd aPlant aPainting doit:)
		(aConveyor4
			cycleSpeed: 1
			setPri: 3
			setCycle: Fwd
			isExtra: 1
			init:
		)
		(aConveyor3
			cycleSpeed: 1
			setPri: 4
			setCycle: Fwd
			isExtra: 1
			init:
		)
		(aConveyor2
			cycleSpeed: 1
			setPri: 4
			setCycle: Fwd
			isExtra: 1
			init:
		)
		(aConveyor1
			cycleSpeed: 1
			setCycle: Fwd
			setPri: 10
			isExtra: 1
			init:
		)
		(aAgentNear setPri: 10 stopUpd: init:)
		(aAgentFar setPri: 1 stopUpd: init:)
		(aTraveler
			setStep: 1 1
			setPri: 2
			illegalBits: 0
			init:
			hide:
		)
		(aPlane startX: 208 startY: 23 endX: 1 endY: 23 init:)
		(cond 
			((== prevRoomNum 54) (ego posn: 316 153))
			((== prevRoomNum 52) (ego posn: 51 119))
			(else (ego posn: 51 119))
		)
		(self setRegions: 500 setScript: rm53Script)
		(if (!= suitcaseBombState 1)
			(NormalEgo)
		else
			(Load rsSOUND 5)
			(theSound play:)
			(HandsOff)
			(= currentStatus 7)
			(rm53Script changeState: 9)
		)
		(ego init:)
		(aDoor
			setPri: 11
			roomCtrl: 0
			locked: (if (== prevRoomNum 54) 0 else 1)
			msgLook:
				{There is a barely perceptible, blue gate in the east wall under that painting.}
			msgLookLock:
				{The gate is controlled by the Customs Official standing behind the counter.}
			msgLocked:
				{The gate is locked. Try talking to the friendly looking gentleman behind the counter.}
			msgExcept: {...except it's locked!}
			msgFunny: {Most people never knock on a gate!}
			msgCloser:
				{When the man releases the gate, it opens just by walking near it.}
			init:
		)
	)
	
	(method (dispose)
		(DisposeScript 992)
		(super dispose:)
	)
)

(instance rm53Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (ego onControl: 1) $0004) (curRoom newRoom: 52))
	)
	
	(method (changeState newState &tmp inventoryFirst temp1)
		(switch (= state newState)
			(1
				(HandsOff)
				(ego setLoop: 3)
				(Print 53 18)
				(= seconds 3)
			)
			(2
				(aAgentNear setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(aAgentNear setCel: 0)
				(Print 53 19 #draw)
				(= seconds 3)
			)
			(4
				(aAgentNear setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(aAgentNear setCel: 0)
				(Print 53 20 #draw)
				(= seconds 3)
			)
			(6
				(Print 53 21)
				(= inventoryFirst (inventory first:))
				(while inventoryFirst
					(if
					((= temp1 (NodeValue inventoryFirst)) ownedBy: ego)
						(temp1 showSelf:)
					)
					(= inventoryFirst (inventory next: inventoryFirst))
				)
				(Print 53 22)
				(= seconds 3)
			)
			(7
				(aAgentNear setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(User canControl: 1 canInput: 1)
				(aAgentNear setCel: 0 stopUpd:)
				(ego setLoop: -1)
				(if (ego has: 17) (Print 53 23) (Print 53 24))
				(Print 53 25 #draw)
				(Print 53 26)
				(Print (Format @str 53 27 tritePhrase))
				(aDoor locked: 0)
			)
			(9
				(ego
					setStep: 4 3
					setLoop: 1
					setMotion: MoveTo 222 154 self
				)
			)
			(10
				(Print 53 28)
				(ego setMotion: MoveTo 157 150 self)
			)
			(11
				(Print (Format @str 53 29 tritePhrase))
				(ego setMotion: MoveTo 43 127 self)
			)
		)
	)
	
	(method (handleEvent event &tmp inventorySaidMe)
		(if
		(or (!= (event type?) evSAID) (event claimed?))
			(return)
		)
		(if (Said 'give,look,throw,conceal,conceal>')
			(cond 
				(
					(or
						(not (= inventorySaidMe (inventory saidMe:)))
						(not (ego has: (inventory indexOf: inventorySaidMe)))
					)
					(event claimed: 0)
				)
				((not (ego inRect: 171 143 198 149)) (NotClose))
				((== (inventory indexOf: inventorySaidMe) 17) (Print 53 0))
				((!= (inventory indexOf: inventorySaidMe) 7) (Print 53 1))
				((== currentEgoView 149) (Print 53 2) (Print 53 3))
				((not passedCustoms)
					(= passedCustoms 1)
					(theGame changeScore: 5)
					(self changeState: 1)
				)
				(else
					(if (ego has: 17)
						(Print 53 4)
						(Print 53 5)
						(Print (Format @str 53 6 tritePhrase))
					else
						(Print (Format @str 53 7 tritePhrase))
					)
					(aDoor locked: 0)
				)
			)
		)
		(if (Said 'look>')
			(if (Said '/man,agent') (Print 53 8))
			(if (Said '/art') (Print 53 9))
			(if (Said '/belt,open,hole') (Print 53 10))
			(if (Said '[/airport,building,belt]')
				(Print 53 11)
				(Print 53 12)
			)
		)
		(if
			(or
				(Said '(crawl<in),board/open,hole,belt')
				(Said 'apply,(climb<on),board/belt')
			)
			(Print 53 13)
		)
		(if (Said '/bathing') (Print 53 14))
		(if (Said 'open/door,door') (Print 53 15))
		(if (Said 'call/man,agent')
			(Print (Format @str 53 16 introductoryPhrase))
			(Print 53 17)
		)
	)
)

(instance travelerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(aTraveler
					posn: 128 36
					show:
					setCycle: Walk
					setMotion: MoveTo 182 37 self
				)
			)
			(2
				(aTraveler
					setLoop: (+ (aTraveler loop?) 1)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(aAgentFar setCycle: End self)
			)
			(4
				(aAgentFar setLoop: 2 setCycle: Fwd)
				(= seconds 10)
			)
			(5
				(aAgentFar setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(6
				(aAgentFar stopUpd:)
				(aTraveler setCycle: Beg self)
			)
			(7
				(aTraveler
					setLoop: (- (aTraveler loop?) 1)
					setCycle: Walk
					setMotion: MoveTo 203 37 self
				)
			)
			(8
				(aTraveler
					setLoop: (if (== (aTraveler loop?) 3) 5 else 3)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance aAd of PV
	(properties
		y 157
		x 25
		view 513
		loop 1
		priority 12
	)
)

(instance aPlant of PV
	(properties
		y 57
		x 73
		view 513
		loop 1
		cel 1
		priority 10
	)
)

(instance aPainting of PV
	(properties
		y 117
		x 301
		view 513
		loop 6
		priority 11
	)
)

(instance aConveyor4 of Prop
	(properties
		y 59
		x 198
		view 513
		loop 5
	)
)

(instance aConveyor3 of Prop
	(properties
		y 69
		x 206
		view 513
		loop 4
	)
)

(instance aConveyor2 of Prop
	(properties
		y 96
		x 218
		view 513
		loop 3
	)
)

(instance aConveyor1 of Prop
	(properties
		y 131
		x 239
		view 513
		loop 2
	)
)

(instance aAgentNear of Prop
	(properties
		y 123
		x 187
		view 514
	)
)

(instance aAgentFar of Prop
	(properties
		y 46
		x 184
		view 514
		loop 1
	)
)

(instance aTraveler of Act
	(properties
		y 36
		x 128
		view 514
		loop 3
		signal $4000
	)
)

(instance aDoor of AutoDoor
	(properties
		y 156
		x 293
		view 513
		msgLook 0
		msgLookLock 18
		msgLocked 38
		msgExcept 59
		msgFunny 82
		msgCloser 102
	)
)

(instance aPlane of Airplane
	(properties)
)
