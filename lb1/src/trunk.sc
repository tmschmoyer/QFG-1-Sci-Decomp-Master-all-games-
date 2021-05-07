;;; Sierra Script 1.0 - (do not remove this comment)
(script# 274)
(include sci.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	trunk 0
)
(synonyms
	(lil person girl)
)

(local
	local0
	local1
	local2
)
(instance trunk of Rgn
	(properties)
	
	(method (init)
		(super init:)
		(if (not (& global118 $0002))
			(LoadMany 135 4 41)
			(LoadMany 143 406)
			(Load rsVIEW 642)
			(LoadMany 132 29 94 95 96)
		)
		(LHead setPri: 11 ignoreActors: 1)
		(suit2 setPri: 11 ignoreActors: 1 init: stopUpd:)
		(Lillian setPri: 11 ignoreActors: 1 init:)
		(= global195 32)
		(self setScript: suitCase)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(return (if (event claimed?) (return 1) else 0))
	)
)

(instance suitCase of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((not global216) (= state -1))
					((not (& global118 $0002))
						(= global118 (| global118 $0002))
						(self setScript: (ScriptID 406 0))
						(= state -1)
					)
					((self script?) (= state -1))
				)
				(= cycles 1)
			)
			(1
				(if (== gCurRoomNum_2 5)
					(= cycles 1)
					(= state 3)
				else
					(Lillian cycleSpeed: 1 setCycle: Fwd)
					(++ gCurRoomNum_2)
					(= seconds 2)
				)
			)
			(2
				(Lillian loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(if (not gCurRoomNum_2) (Print 274 0))
				(= cycles 1)
			)
			(4
				(LHead init: setScript: headActions)
				(= cycles 1)
			)
			(5
				(Lillian loop: 4 cycleSpeed: 1 setCycle: End)
				(= seconds (Random 6 15))
			)
			(6
				(Lillian setCycle: Beg)
				(= seconds (Random 6 15))
				(= state 4)
			)
		)
	)
)

(instance headActions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(LHead setCycle: End)
				(= seconds (Random 6 15))
			)
			(1
				(LHead setCycle: Beg)
				(= seconds (Random 6 15))
				(= state -1)
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 149
		x 270
		view 511
		loop 3
	)
	
	(method (handleEvent event)
		(= theTalker 6)
		(cond 
			(
				(and
					(not (& global207 $0020))
					(or (MousedOn self event 3) (Said 'examine/lil'))
				)
				(= global207 (| global207 $0020))
				(= theTalker 6)
				(event claimed: 1)
				(Say 0 274 1)
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event 3) (Said 'examine/lil'))
				)
				(event claimed: 1)
				(Print 274 2)
			)
			((Said 'ask//*<about')
				(switch local2
					(0 (Say 1 274 3) (++ local2))
					(1 (Print 274 4))
				)
			)
			((Said 'tell//*<about') (Print 274 5))
			((Said 'deliver/*')
				(if (and theInvItem haveInvItem)
					(Print 274 6)
				else
					(DontHave)
				)
			)
			((Said 'hold/*')
				(if (and theInvItem haveInvItem)
					(Print 274 7)
				else
					(DontHave)
				)
			)
			((Said '/lil>')
				(cond 
					((Said 'converse')
						(switch local0
							(0 (Say 1 274 8))
							(1 (Say 1 274 9))
							(2 (Say 1 274 10))
							(3 (Say 1 274 11))
							(4 (Say 1 274 12))
							(else  (Print 274 13))
						)
						(++ local0)
					)
					((Said 'hear') (Print 274 14))
					((Said 'get') (Print 274 15))
					((Said 'kill') (Print 274 16))
					((Said 'kiss') (Print 274 17))
					((Said 'embrace') (Print 274 18))
				)
			)
		)
	)
)

(instance suit2 of Prop
	(properties
		y 137
		x 262
		view 511
		loop 2
	)
)

(instance LHead of Prop
	(properties
		y 148
		x 273
		z 32
		view 511
		loop 5
	)
)
