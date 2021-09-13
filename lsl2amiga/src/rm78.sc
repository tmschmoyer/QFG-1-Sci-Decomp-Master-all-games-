;;; Sierra Script 1.0 - (do not remove this comment)
(script# 78)
(include sci.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm78 0
)

(local
	local0
	thePedaler
	theChief
	theDrummer
	theMouth
)
(instance rm78 of Rm
	(properties
		picture 78
		horizon 5
		west 77
	)
	
	(method (init)
		(if (== endGameState 105) (self style: 8))
		(super init:)
		(NormalEgo)
		(ego posn: 9 133 init:)
		(self setScript: rm78Script)
		(if global111 (= endGameState 105))
		(if (!= endGameState 105)
			(self setRegions: 700)
			(Load rsVIEW 716)
			(aWoodchopper cycleSpeed: 1 init: setScript: woodScript)
		else
			(HandsOff)
			(rm78Script changeState: 1)
			(Load rsVIEW 833)
			(Load rsVIEW 212)
			(Load rsVIEW 711)
			(Load rsVIEW 710)
			(Load rsVIEW 714)
			(Load rsVIEW 713)
			(Load rsVIEW 707)
			(Load rsVIEW 704)
			(Load rsVIEW 706)
			(Load rsVIEW 822)
			(Load rsVIEW 823)
			(Load rsSOUND 111)
			(theSound init:)
			(addToPics
				add: aBitch1 aBitch2 aBitch3 aBitch4 aMother1 aMother2 aFamily
				doit:
			)
			(aDrummer setLoop: 1 stopUpd: init:)
			(aPedaler setLoop: 7 stopUpd: init:)
			(aDoctor
				setLoop: 3
				setPri: 14
				setCycle: Walk
				illegalBits: 0
				stopUpd:
				init:
			)
			(aHulaHooper
				setLoop: 0
				illegalBits: 0
				setCycle: Walk
				setStep: 1 1
				stopUpd:
				init:
			)
			(aDancer
				setLoop: 1
				illegalBits: 0
				setCycle: Walk
				setStep: 2 1
				stopUpd:
				init:
			)
			(aKalalau
				illegalBits: 0
				setCycle: Walk
				setStep: 3 2
				cycleSpeed: 1
				moveSpeed: 1
				init:
			)
			(aChief
				illegalBits: 0
				setPri: 9
				setCycle: Walk
				cycleSpeed: 1
				moveSpeed: 1
				init:
			)
			(aMouth setPri: 10 setCycle: Fwd init:)
			(aCameraman
				setLoop: 0
				illegalBits: 0
				setPri: 14
				posn: 99 179
				moveSpeed: 2
				cycleSpeed: 2
				setCycle: Walk
				setStep: 3 2
				init:
				setScript: minicamScript
			)
			(aPhotographer
				setLoop: 2
				illegalBits: 0
				setCycle: Walk
				setPri: 13
				stopUpd:
				init:
			)
		)
	)
)

(instance rm78Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(!= endGameState 105)
				(== (ego loop?) 3)
				(== 6 (aWoodchopper cel?))
				(ego inRect: 34 100 43 107)
				(== currentStatus 0)
			)
			(self changeState: 47)
		)
	)
	
	(method (changeState newState &tmp egoCycleSpeed)
		(switch (= state newState)
			(1 (= cycles 2))
			(2 (Print 78 10) (= cycles 20))
			(3
				(theSound play:)
				(Print 78 11)
				(aDrummer setCycle: Fwd)
				(aHulaHooper setMotion: MoveTo 222 123 self)
				(aDancer setMotion: MoveTo 46 111 self)
			)
			(5
				(Print 78 12)
				(aHulaHooper setLoop: 5 cel: 0 stopUpd:)
				(aDancer cel: 0 stopUpd:)
				(ego setMotion: MoveTo 163 134 self)
			)
			(6
				(ego setLoop: 2 stopUpd:)
				(= seconds 3)
			)
			(7 (Print 78 13) (= seconds 3))
			(8
				(aKalalau setMotion: MoveTo 182 152 self)
				(aChief setMotion: MoveTo 100 138 self)
				(aPedaler setCycle: Fwd)
				(minicamScript changeState: 5)
			)
			(10
				(aKalalau setLoop: 1)
				(ego setMotion: MoveTo 165 152 self)
			)
			(11
				(aKalalau hide:)
				(ego view: 822 setLoop: 0 cel: 0 posn: 172 151)
				(Print 78 14 #draw)
				(aChief stopUpd:)
				(aMouth posn: (+ (aChief x?) -1) (+ (aChief y?) -25))
				(= seconds 3)
			)
			(12
				(aMouth posn: 666 666)
				(= theMouth aMouth)
				(= theChief aChief)
				(ego stopUpd:)
				(Print 78 15 #draw)
				(AddViewToPic aChief)
				(theChief posn: 888 888)
				(= seconds 3)
			)
			(13
				(Print 78 16)
				(minicamScript changeState: 3)
				(= seconds 3)
			)
			(14
				(Print 78 17)
				(= seconds 3)
			)
			(15
				(Print 78 18)
				(theSound stop:)
				(AddViewToPic aDrummer)
				((= theDrummer aDrummer) posn: 777 777)
				(Print 78 19)
				(= seconds 3)
			)
			(16
				(ego cycleSpeed: 2 setCycle: End self)
			)
			(17
				(ego cycleSpeed: 6 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= cycles 12)
			)
			(18
				(if (= egoCycleSpeed (ego cycleSpeed?))
					(-- egoCycleSpeed)
					(ego cycleSpeed: egoCycleSpeed)
					(-- state)
				)
				(= cycles 8)
			)
			(19 (= seconds 6))
			(20
				(if (< (= egoCycleSpeed (ego cycleSpeed?)) 8)
					(++ egoCycleSpeed)
					(ego cycleSpeed: egoCycleSpeed)
					(-- state)
				)
				(= cycles 8)
			)
			(21
				(ego setLoop: 2)
				(Print 78 20)
				(= cycles 10)
			)
			(22
				(ego cycleSpeed: 2 setLoop: 6 setCycle: End self)
			)
			(23 (= cycles 20))
			(24
				(Print 78 21)
				(= cycles 22)
			)
			(25
				(Print 78 22 #at -1 130)
				(= cycles 22)
			)
			(26
				(aKalalau
					show:
					setLoop: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 62 152
				)
				(ego
					view: 100
					setLoop: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 45 152 self
				)
			)
			(27
				(aKalalau setLoop: 1 setMotion: MoveTo 189 152)
				(ego setLoop: 1 setMotion: MoveTo 172 152 self)
			)
			(28
				(ego setLoop: 0)
				(Print 78 23 #draw)
				(= cycles 10)
			)
			(29
				(aKalalau hide:)
				(ego
					view: 706
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(30 (= seconds 5))
			(31
				(Print 78 24 #at -1 130)
				(ego setCycle: Beg self)
			)
			(32
				(ego view: 822 setLoop: 2 cycleSpeed: 0 setCycle: Walk)
				(= seconds 3)
			)
			(33
				(Print 78 25)
				(AddViewToPic aPedaler)
				((= thePedaler aPedaler) posn: 999 999)
				(aPhotographer setMotion: MoveTo 132 160 self)
			)
			(34
				(aPhotographer setLoop: 3 cel: 0 setCycle: End self)
			)
			(35
				(aDoctor view: 713 setLoop: 1 setCycle: Fwd)
				(= cycles 50)
			)
			(36
				(theDrummer
					view: 822
					loop: 3
					posn: 170 138
					cel: 0
					cycleSpeed: 2
					setPri: 13
					setCycle: End self
				)
			)
			(37
				(aDoctor view: 711 setLoop: 3 setCycle: Walk stopUpd:)
				(thePedaler
					view: 822
					setLoop: 4
					posn: 154 105
					setCycle: Fwd
				)
				(theChief
					view: 822
					setLoop: 5
					posn: 186 105
					setCycle: Fwd
				)
				(= cycles 30)
			)
			(38
				(theMouth
					view: 823
					setLoop: 4
					setPri: 12
					cel: 0
					posn: (+ (aPhotographer x?) 5) (- (aPhotographer y?) 35)
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(39
				(theMouth dispose:)
				(aPhotographer setCycle: Beg self)
			)
			(40 (= cycles 10))
			(41
				(theDrummer setCycle: Beg self)
				(thePedaler dispose:)
				(theChief dispose:)
			)
			(42
				(theDrummer dispose:)
				(= seconds 3)
			)
			(43
				(Print 78 26)
				(Print 78 27)
				(aKalalau setLoop: 1 show:)
				(ego
					view: 100
					setPri: -1
					setLoop: -1
					loop: 2
					posn: 165 151
				)
				(aDoctor setPri: -1 setMotion: MoveTo 150 152 self)
			)
			(44
				(aDoctor setMotion: MoveTo 165 116 self)
				(= cycles 5)
			)
			(45
				(Print 78 28)
				(ego setMotion: MoveTo 171 120)
			)
			(46 (curRoom newRoom: 178))
			(47
				(HandsOff)
				(= currentStatus 1000)
				(aWoodchopper setScript: 0 setCel: 255 stopUpd:)
				(Print 78 29 #draw)
				(Print 78 30)
				(= seconds 3)
			)
			(48
				(= currentStatus 1001)
				(Print 78 31)
			)
		)
	)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) evSAID) (event claimed?))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/man,children') (Print 78 0))
			(if (Said '/door') (Print 78 1))
			(if (Said '[/airport,angeles,hut]')
				(Print 78 2)
				(Print 78 3)
			)
		)
		(if
			(or
				(Said '(board<in),(disembark<in),climb,board/stair,hut')
				(Said 'look/cup')
				(Said 'bang,open/door')
			)
			(Print 78 4)
		)
		(if (Said 'call/man,children')
			(if (ego inRect: 0 0 91 120)
				(Print 78 5)
				(Print 78 6 #at -1 130)
			else
				(NotClose)
			)
		)
		(if (Said '/man,children') (Print 78 7))
		(if (Said '/axe') (Print 78 8))
		(if (Said '/[') (Print 78 9))
	)
)

(instance woodScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 8))
			(1
				(aWoodchopper setCycle: End self)
			)
			(2
				(= cycles (++ local0))
				(= state 0)
			)
		)
	)
)

(instance minicamScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(aCameraman loop: 2 setCycle: End self)
			)
			(2 (aCameraman stopUpd:))
			(3
				(aCameraman setCycle: Beg self)
			)
			(4
				(aCameraman setCycle: Walk setMotion: MoveTo 180 179 self)
				(= state 0)
			)
			(5
				(aCameraman setCycle: Beg self)
			)
			(6
				(aCameraman setCycle: Walk setMotion: MoveTo 120 179 self)
				(= state 0)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 111
		loop -1
	)
)

(instance aBitch1 of PV
	(properties
		y 122
		x 90
		view 833
		cel 255
		signal $4000
	)
)

(instance aBitch2 of PV
	(properties
		y 119
		x 105
		view 833
		loop 1
		cel 255
		signal $4000
	)
)

(instance aBitch3 of PV
	(properties
		y 116
		x 120
		view 833
		loop 2
		cel 255
		signal $4000
	)
)

(instance aBitch4 of PV
	(properties
		y 113
		x 135
		view 833
		loop 3
		cel 255
		signal $4000
	)
)

(instance aMother1 of PV
	(properties
		y 105
		x 67
		view 714
		loop 3
		cel 1
		signal $4000
	)
)

(instance aMother2 of PV
	(properties
		y 116
		x 206
		view 714
		loop 2
		cel 1
		signal $4000
	)
)

(instance aFamily of PV
	(properties
		y 108
		x 16
		view 714
		loop 3
		signal $4000
	)
)

(instance aWoodchopper of Prop
	(properties
		y 102
		x 55
		view 716
	)
)

(instance aDrummer of Prop
	(properties
		y 145
		x 233
		view 714
		signal $4000
	)
)

(instance aPedaler of Prop
	(properties
		y 163
		x 212
		view 707
		signal $4000
	)
)

(instance aDoctor of Act
	(properties
		y 171
		x 159
		view 711
	)
)

(instance aHulaHooper of Act
	(properties
		y 128
		x 146
		view 823
		signal $4000
	)
)

(instance aDancer of Act
	(properties
		y 144
		x 118
		view 823
		signal $4000
	)
)

(instance aKalalau of Act
	(properties
		y 141
		x -28
		view 704
		loop 1
		signal $4000
	)
)

(instance aChief of Act
	(properties
		y 137
		x -22
		view 710
		signal $4000
	)
)

(instance aMouth of Prop
	(properties
		y 999
		x 999
		view 710
		loop 4
		signal $4000
	)
)

(instance aCameraman of Act
	(properties
		view 212
		signal $4000
	)
)

(instance aPhotographer of Act
	(properties
		y 169
		x 56
		view 823
		cel 5
		signal $4000
	)
)
